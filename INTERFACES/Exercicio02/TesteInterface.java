package org.exercicio02;

public class TesteInterface {

    public static void main(String[] args) {

        Pagamento[] pagamentos = new Pagamento[4];

        pagamentos[0] = new Fatura(
            "001", "Teclado", 2, 150.00
        );

        pagamentos[1] = new Fatura(
            "002", "Mouse", 3, 80.00
        );

        pagamentos[2] = new FuncionarioMensalista(
            "Carlos", "Silva", "111.111.111-11", 3500.00
        );

        pagamentos[3] = new FuncionarioMensalista(
            "Ana", "Souza", "222.222.222-22", 4200.00
        );

        for (int i = 0; i < pagamentos.length; i++) {

            System.out.printf(
                "=== PAGAMENTO %d ===%n", i + 1
            );

            System.out.printf(
                "%s%n", pagamentos[i].toString()
            );

            System.out.printf(
                "Valor do pagamento: R$ %.2f%n%n",
                pagamentos[i].getValorPagamento()
            );
        }
    }
}