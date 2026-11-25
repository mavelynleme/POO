package br.edu.qrstudy;

import java.net.URI;
import java.util.List;
import jakarta.validation.Valid;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/alunos")
@Tag(name = "Alunos")
public class AlunoController {
    private final CadastroAlunos cadastro;
    public AlunoController(CadastroAlunos cadastro) { this.cadastro = cadastro; }

    @PostMapping
    @Operation(summary="Cadastrar aluno", description="Cria a matrícula na escola informada e devolve a localização do aluno no cabeçalho Location.")
    @ApiResponse(responseCode="201", description="Aluno cadastrado", useReturnTypeSchema=true)
    @ApiResponse(responseCode="400", description="Dados inválidos", content=@Content)
    @ApiResponse(responseCode="409", description="Matrícula já utilizada nesta escola", content=@Content)
    public ResponseEntity<Aluno> criar(@Valid @RequestBody DadosAluno dados) {
        Aluno aluno = cadastro.criar(dados);
        return ResponseEntity.created(URI.create("/api/alunos/" + aluno.id())).body(aluno);
    }

    @GetMapping
    @Operation(summary="Listar alunos", description="Lista todos os alunos em ordem de nome.")
    @ApiResponse(responseCode="200", description="Lista de alunos, possivelmente vazia", useReturnTypeSchema=true)
    public List<Aluno> listar() { return cadastro.listar(); }

    @GetMapping("/{id}")
    @Operation(summary="Consultar aluno", description="Busca o cadastro pelo identificador gerado na criação.")
    @ApiResponse(responseCode="200", description="Aluno encontrado", useReturnTypeSchema=true)
    @ApiResponse(responseCode="400", description="ID inválido", content=@Content)
    @ApiResponse(responseCode="404", description="Aluno inexistente", content=@Content)
    public Aluno buscar(@PathVariable long id) { return cadastro.buscar(id); }

    @PutMapping("/{id}")
    @Operation(summary="Atualizar aluno", description="Substitui todos os dados cadastrais e preserva o identificador.")
    @ApiResponse(responseCode="200", description="Cadastro atualizado", useReturnTypeSchema=true)
    @ApiResponse(responseCode="400", description="Dados ou ID inválidos", content=@Content)
    @ApiResponse(responseCode="404", description="Aluno inexistente", content=@Content)
    @ApiResponse(responseCode="409", description="Matrícula já utilizada nesta escola", content=@Content)
    public Aluno atualizar(@PathVariable long id, @Valid @RequestBody DadosAluno dados) {
        return cadastro.atualizar(id, dados);
    }

    @DeleteMapping("/{id}")
    @Operation(summary="Excluir aluno", description="Remove o cadastro identificado pelo ID.")
    @ApiResponse(responseCode="204", description="Cadastro excluído", content=@Content)
    @ApiResponse(responseCode="400", description="ID inválido", content=@Content)
    @ApiResponse(responseCode="404", description="Aluno inexistente", content=@Content)
    public ResponseEntity<Void> excluir(@PathVariable long id) {
        cadastro.excluir(id);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public ProblemDetail duplicada() {
        return ProblemDetail.forStatusAndDetail(HttpStatus.CONFLICT, "Esta matrícula já existe nesta escola.");
    }
}
