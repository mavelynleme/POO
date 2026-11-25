package br.edu.qrstudy;

import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Repository
public class CadastroAlunos {
    private final JdbcClient banco;
    public CadastroAlunos(JdbcClient banco) { this.banco = banco; }

    private static final RowMapper<Aluno> MAPEAR = (r, posicao) -> new Aluno(r.getLong("id"),
        new DadosAluno(r.getLong("escola"), r.getString("nome"), r.getDate("nascimento").toLocalDate(),
            r.getString("matricula"), r.getString("serie"), r.getString("turma"),
            DadosAluno.Turno.valueOf(r.getString("turno")), DadosAluno.Status.valueOf(r.getString("status"))));

    public List<Aluno> listar() {
        return banco.sql("SELECT * FROM aluno ORDER BY nome, id").query(MAPEAR).list();
    }
    public Aluno buscar(long id) {
        return banco.sql("SELECT * FROM aluno WHERE id = ?").param(id).query(MAPEAR)
            .optional().orElseThrow(CadastroAlunos::ausente);
    }
    @Transactional
    public Aluno criar(DadosAluno dados) {
        var chave = new GeneratedKeyHolder();
        comando("""
            INSERT INTO aluno (escola,nome,nascimento,matricula,serie,turma,turno,status)
            VALUES (:escola,:nome,:nascimento,:matricula,:serie,:turma,:turno,:status)
            """, dados).update(chave, "id");
        return new Aluno(chave.getKey().longValue(), dados);
    }
    @Transactional
    public Aluno atualizar(long id, DadosAluno dados) {
        int linhas = comando("""
            UPDATE aluno SET escola=:escola,nome=:nome,nascimento=:nascimento,matricula=:matricula,
                serie=:serie,turma=:turma,turno=:turno,status=:status WHERE id=:id
            """, dados).param("id", id).update();
        if (linhas == 0) throw ausente();
        return new Aluno(id, dados);
    }
    public void excluir(long id) {
        if (banco.sql("DELETE FROM aluno WHERE id = ?").param(id).update() == 0) throw ausente();
    }
    private JdbcClient.StatementSpec comando(String sql, DadosAluno d) {
        return banco.sql(sql).param("escola", d.escola()).param("nome", d.nome())
            .param("nascimento", d.nascimento()).param("matricula", d.matricula())
            .param("serie", d.serie()).param("turma", d.turma())
            .param("turno", d.turno().name()).param("status", d.status().name());
    }
    private static ResponseStatusException ausente() {
        return new ResponseStatusException(NOT_FOUND, "Aluno não encontrado.");
    }
}
