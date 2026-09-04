// Indica que esta classe faz parte do pacote comentados.
package comentados;

// Import permite usar a classe Scanner, que pertence ao pacote java.util.
import java.util.Scanner;

// Classe usada para criar um objeto ValorComentado e testar seus metodos.
public class TesteValorComentado {
    // main e o ponto de inicio da aplicacao Java.
    // public permite que a JVM acesse o metodo; static permite executa-lo sem criar
    // um objeto desta classe; void indica que ele nao retorna valor; args recebe
    // argumentos escritos na linha de comando.
    public static void main(String[] args) {
        // Cria um Scanner chamado entrada.
        // new cria uma instancia, e System.in representa a entrada pelo teclado.
        Scanner entrada = new Scanner(System.in);

        // new ValorComentado() cria uma instancia da classe ValorComentado.
        // A variavel valor guarda a referencia para esse objeto.
        ValorComentado valor = new ValorComentado();

        // print exibe a mensagem sem mudar de linha.
        System.out.print("Digite um numero: ");

        // numero e uma variavel local do tipo int, existente apenas dentro do main.
        // nextInt le um numero inteiro digitado pelo usuario.
        int numero = entrada.nextInt();

        // Chama o metodo set e envia numero como argumento.
        // Argumento e o valor usado na chamada; parametro e a variavel que o recebe.
        valor.setNumero(numero);

        // printf permite montar uma saida formatada.
        // O primeiro %d recebe o int devolvido por getNumero.
        // O segundo %d recebe o long devolvido por calcularFatorial.
        // %n muda para a proxima linha de forma compativel com o sistema operacional.
        System.out.printf("O fatorial de %d e %d%n",
                valor.getNumero(), valor.calcularFatorial());

        // Fecha o Scanner depois que a leitura nao e mais necessaria.
        entrada.close();
    }
}
