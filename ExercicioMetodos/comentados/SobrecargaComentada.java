// Indica que a classe pertence ao pacote comentados.
package comentados;

// Locale sera usado para imprimir numeros reais com ponto decimal.
import java.util.Locale;

// Classe que demonstra a sobrecarga de metodos.
public class SobrecargaComentada {
    // Sobrecarga ocorre quando existem metodos com o mesmo nome, mas assinaturas
    // diferentes. A assinatura considera o nome e a lista de tipos dos parametros.
    // Java escolhe o metodo adequado pela quantidade e pelos tipos dos argumentos.

    // Assinatura: adiciona(int, int).
    // int representa numeros inteiros. void indica que nao ha valor retornado.
    public void adiciona(int valor1, int valor2) {
        int resultado = valor1 + valor2;
        // Cada %d e substituido por um numero inteiro, e %n muda de linha.
        System.out.printf("%d + %d = %d%n", valor1, valor2, resultado);
    }

    // Assinatura: adiciona(int, int, int).
    // Pode coexistir com a anterior porque possui tres parametros, e nao dois.
    public void adiciona(int valor1, int valor2, int valor3) {
        int resultado = valor1 + valor2 + valor3;
        System.out.printf("%d + %d + %d = %d%n",
                valor1, valor2, valor3, resultado);
    }

    // Assinatura: adiciona(double, double).
    // double representa numeros reais, que podem possuir casas decimais.
    public void adiciona(double valor1, double valor2) {
        double resultado = valor1 + valor2;
        // %f formata um numero real; %.2f limita a exibicao a duas casas decimais.
        // Locale.US faz o separador decimal ser um ponto.
        System.out.printf(Locale.US, "%.2f + %.2f = %.2f%n",
                valor1, valor2, resultado);
    }

    // Assinatura: adiciona(String, String).
    // String representa texto. Os dois textos sao unidos por concatenacao com +.
    public void adiciona(String nome, String sobrenome) {
        // A String com um espaco separa o nome do sobrenome.
        String nomeCompleto = nome + " " + sobrenome;
        // %s indica onde o texto de nomeCompleto sera colocado.
        System.out.printf("Nome completo: %s%n", nomeCompleto);
    }
}
