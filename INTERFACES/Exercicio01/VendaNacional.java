package org.exercicio01;

public class VendaNacional extends Produto implements Venda {

    private double imposto;
    private int quantidade;

    public VendaNacional(String nome, String categoria,
                         double preco, int estoque,
                         double imposto, int quantidade) {

        super(nome, categoria, preco, estoque);
        this.imposto = imposto;
        this.quantidade = quantidade;
    }

    public double getImposto() {
        return imposto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    @Override
    public double calcularDesconto() {
        return getPreco() * getQuantidade() * 0.10;
    }

    @Override
    public double calcularTotal() {
        return getPreco() * getQuantidade()
               + getImposto() - calcularDesconto();
    }

    @Override
    public String toString() {
        return String.format(
            "%s%nImposto: R$ %.2f%nQuantidade: %d",
            super.toString(), getImposto(), getQuantidade()
        );
    }
}