package br.edu.qrstudy;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "QRStudy | Cadastro de alunos", version = "1.0",
    description = "Módulo acadêmico de cadastro de alunos do sistema de retirada escolar por QR Code. Cada escola possui sua própria numeração de matrículas."))
public class Aplicacao {
    public static void main(String[] args) {
        SpringApplication.run(Aplicacao.class, args);
    }
}
