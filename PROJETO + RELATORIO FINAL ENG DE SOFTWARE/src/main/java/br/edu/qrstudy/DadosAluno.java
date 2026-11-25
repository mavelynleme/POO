package br.edu.qrstudy;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public record DadosAluno(
    @NotNull @Positive Long escola,
    @NotBlank @Size(max=150) String nome,
    @NotNull @PastOrPresent LocalDate nascimento,
    @NotBlank @Size(max=30) String matricula,
    @NotBlank @Size(max=30) String serie,
    @NotBlank @Size(max=30) String turma,
    @NotNull Turno turno,
    @NotNull Status status
) {
    public enum Turno { MANHA, TARDE, NOITE, INTEGRAL }
    public enum Status { ATIVO, INATIVO, TRANSFERIDO, FORMADO }
    public DadosAluno {
        nome = limpar(nome);
        matricula = limpar(matricula);
        serie = limpar(serie);
        turma = limpar(turma);
    }
    private static String limpar(String valor) {
        return valor == null ? null : valor.strip();
    }
}
