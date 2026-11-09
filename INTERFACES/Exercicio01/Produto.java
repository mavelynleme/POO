package org.exercicio01;

public class Produto {

    private String nome;
    private String categoria;
    private double preco;
    private int estoque;

    public Produto(String nome, String categoria,
                   double preco, int estoque) {
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
        this.estoque = estoque;
    }

    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getPreco() {
        return preco;
    }

    public int getEstoque() {
        return estoque;
    }

    @Override
    public String toString() {
        return String.format(
            "Nome: %s%nCategoria: %s%nPreco: R$ %.2f%nEstoque: %d",
            getNome(), getCategoria(), getPreco(), getEstoque()
        );
    }
}