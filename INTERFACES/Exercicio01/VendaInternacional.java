package org.exercicio01;

public class VendaInternacional extends Produto implements Venda {

    private double taxaImportacao;
    private double frete;
    private int quantidade;

    public VendaInternacional(String nome, String categoria,
                              double preco, int estoque,
                              double taxaImportacao, double frete,
                              int quantidade) {

        super(nome, categoria, preco, estoque);
        this.taxaImportacao = taxaImportacao;
        this.frete = frete;
        this.quantidade = quantidade;
    }

    public double getTaxaImportacao() {
        return taxaImportacao;
    }

    public double getFrete() {
        return frete;
    }

    public int getQuantidade() {
        return quantidade;
    }

    @Override
    public double calcularDesconto() {
        return getPreco() * getQuantidade() * 0.05;
    }

    @Override
    public double calcularTotal() {
        return getPreco() * getQuantidade()
               + getTaxaImportacao()
               + getFrete()
               - calcularDesconto();
    }

    @Override
    public String toString() {
        return String.format(
            "%s%nTaxa de importacao: R$ %.2f%nFrete: R$ %.2f%nQuantidade: %d",
            super.toString(), getTaxaImportacao(),
            getFrete(), getQuantidade()
        );
    }
}