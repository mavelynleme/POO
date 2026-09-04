package exerciciometodos;

import java.util.Locale;

public class Sobrecarga {
    public void adiciona(int valor1, int valor2) {
        int resultado = valor1 + valor2;
        System.out.printf("%d + %d = %d%n", valor1, valor2, resultado);
    }

    public void adiciona(int valor1, int valor2, int valor3) {
        int resultado = valor1 + valor2 + valor3;
        System.out.printf("%d + %d + %d = %d%n",
                valor1, valor2, valor3, resultado);
    }

    public void adiciona(double valor1, double valor2) {
        double resultado = valor1 + valor2;
        System.out.printf(Locale.US, "%.2f + %.2f = %.2f%n",
                valor1, valor2, resultado);
    }

    public void adiciona(String nome, String sobrenome) {
        String nomeCompleto = nome + " " + sobrenome;
        System.out.printf("Nome completo: %s%n", nomeCompleto);
    }
}
