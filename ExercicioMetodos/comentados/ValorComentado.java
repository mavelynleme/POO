// Package agrupa classes relacionadas e evita conflitos com classes de outros pacotes.
// Esta classe pertence ao pacote comentados, separado dos arquivos originais.
package comentados;

// Declara a classe publica ValorComentado.
// Uma classe funciona como um modelo para criar objetos.
public class ValorComentado {
    // Atributo do tipo int que armazena um numero inteiro no objeto.
    // private protege o atributo contra acesso direto por outras classes.
    private int numero;

    // Metodo set: altera o valor do atributo numero.
    // void indica que o metodo executa uma acao e nao retorna um valor.
    // O valor entre parenteses e o parametro recebido pelo metodo.
    public void setNumero(int numero) {
        // this.numero representa o atributo do objeto atual.
        // numero representa o parametro recebido pelo metodo.
        this.numero = numero;
    }

    // Metodo get: permite consultar o atributo numero.
    // int antes do nome informa o tipo do valor que sera retornado.
    public int getNumero() {
        // return devolve o numero armazenado para quem chamou o metodo.
        return numero;
    }

    // Calcula o fatorial usando o numero armazenado no objeto.
    // long armazena numeros inteiros maiores do que o tipo int.
    public long calcularFatorial() {
        // Comeca com 1 porque esse valor nao altera uma multiplicacao.
        // Isso tambem faz o fatorial de zero resultar em 1.
        long fatorial = 1;

        // O for repete o bloco enquanto i for maior que 1.
        // i comeca com numero e i-- diminui seu valor em uma unidade a cada volta.
        for (int i = numero; i > 1; i--) {
            // Multiplica o resultado acumulado pelo valor atual de i.
            // Para 5, as multiplicacoes sao 1 * 5 * 4 * 3 * 2.
            fatorial = fatorial * i;
        }

        // Retorna o resultado do fatorial para quem chamou o metodo.
        return fatorial;
    }
}
