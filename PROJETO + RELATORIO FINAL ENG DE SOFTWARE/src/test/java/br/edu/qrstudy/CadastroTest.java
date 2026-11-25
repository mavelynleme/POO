package br.edu.qrstudy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(properties="spring.datasource.url=jdbc:h2:mem:teste;DB_CLOSE_DELAY=-1")
@AutoConfigureMockMvc
class CadastroTest {
    @Autowired MockMvc http;
    private static final String BASE = "/api/alunos";
    private static final String DADOS = """
        {"escola":1,"nome":"Ana Exemplo","nascimento":"2015-04-10","matricula":"A10",
         "serie":"5º ano","turma":"B","turno":"MANHA","status":"ATIVO"}
        """;

    @Test
    void cicloCompleto() throws Exception {
        var criado = http.perform(post(BASE).contentType("application/json").content(DADOS))
            .andExpect(status().isCreated()).andExpect(jsonPath("$.id").isNumber()).andReturn();
        String url = criado.getResponse().getHeader("Location");
        http.perform(get(BASE)).andExpect(status().isOk()).andExpect(jsonPath("$[0].dados.nome").value("Ana Exemplo"));
        http.perform(get(url)).andExpect(status().isOk()).andExpect(jsonPath("$.dados.matricula").value("A10"));
        http.perform(post(BASE).contentType("application/json").content(DADOS)).andExpect(status().isConflict());
        http.perform(put(url).contentType("application/json").content(DADOS.replace("MANHA","TARDE")))
            .andExpect(status().isOk()).andExpect(jsonPath("$.dados.turno").value("TARDE"));
        http.perform(get(url)).andExpect(jsonPath("$.dados.turno").value("TARDE"));
        http.perform(delete(url)).andExpect(status().isNoContent());
        http.perform(get(url)).andExpect(status().isNotFound());
        http.perform(delete(url)).andExpect(status().isNotFound());
        http.perform(put(url).contentType("application/json").content(DADOS)).andExpect(status().isNotFound());
        http.perform(post(BASE).contentType("application/json").content("{}")).andExpect(status().isBadRequest());
    }

    @Test
    void publicaInterfaceEDocumentacao() throws Exception {
        http.perform(get("/index.html")).andExpect(status().isOk());
        http.perform(get("/v3/api-docs")).andExpect(status().isOk())
            .andExpect(jsonPath("$.info.title").value("QRStudy | Cadastro de alunos"))
            .andExpect(jsonPath("$.paths['/api/alunos'].post.responses['201']").exists())
            .andExpect(jsonPath("$.paths['/api/alunos/{id}'].delete.responses['404']").exists());
    }
}
