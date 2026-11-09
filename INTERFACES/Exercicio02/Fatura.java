package org.exercicio02;


public class Fatura implements Pagamento {

    private String numero;
    private String descricao;
    private int quantidade;
    private double precoItem;

    public Fatura(String numero, String descricao,
                  int quantidade, double precoItem) {

        this.numero = numero;
        this.descricao = descricao;
        setQuantidade(quantidade);
        setPrecoItem(precoItem);
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPrecoItem() {
        return precoItem;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = (quantidade < 0) ? 0 : quantidade;
    }

    public void setPrecoItem(double precoItem) {
        this.precoItem = (precoItem < 0) ? 0 : precoItem;
    }

    @Override
    public double getValorPagamento() {
        return getQuantidade() * getPrecoItem();
    }

    @Override
    public String toString() {
        return String.format(
            "Numero: %s%nDescricao: %s%nQuantidade: %d%nPreco por item: R$ %.2f",
            getNumero(), getDescricao(),
            getQuantidade(), getPrecoItem()
        );
    }
}