package exerciciometodos;

import java.util.Scanner;

public class TesteValor {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Valor valor = new Valor();

        System.out.print("Digite um numero: ");
        int numero = entrada.nextInt();
        valor.setNumero(numero);

        System.out.printf("O fatorial de %d e %d%n",
                valor.getNumero(), valor.calcularFatorial());

        entrada.close();
    }
}
