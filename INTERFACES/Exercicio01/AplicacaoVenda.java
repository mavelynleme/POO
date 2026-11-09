package org.exercicio01;

public class AplicacaoVenda {

    public static void main(String[] args) {

        VendaNacional nacional = new VendaNacional(
            "Teclado", "Informatica", 100.00, 50,
            20.00, 2
        );

        VendaInternacional internacional = new VendaInternacional(
            "Monitor", "Eletronicos", 1000.00, 20,
            150.00, 80.00, 2
        );

        System.out.printf("=== VENDA NACIONAL ===%n%s%n",
                          nacional.toString());
        System.out.printf("Desconto: R$ %.2f%n",
                          nacional.calcularDesconto());
        System.out.printf("Total: R$ %.2f%n%n",
                          nacional.calcularTotal());

        System.out.printf("=== VENDA INTERNACIONAL ===%n%s%n",
                          internacional.toString());
        System.out.printf("Desconto: R$ %.2f%n",
                          internacional.calcularDesconto());
        System.out.printf("Total: R$ %.2f%n",
                          internacional.calcularTotal());
    }
}