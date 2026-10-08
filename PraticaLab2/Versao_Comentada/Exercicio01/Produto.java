// Superclasse: reúne as características comuns aos produtos.
public class Produto {
    // Os atributos são privados para manter o encapsulamento.
    private int codigo;
    private double preco;
    private String descricao;

    // Construtor: recebe os valores no momento da criação do objeto.
    public Produto(int codigo, double preco, String descricao) {
        this.codigo = codigo;
        this.preco = preco;
        this.descricao = descricao;
    }

    // Métodos get permitem consultar cada atributo privado.
    public int getCodigo() { return codigo; }
    public double getPreco() { return preco; }
    public String getDescricao() { return descricao; }
}

// Livro herda os atributos e os métodos públicos de Produto.
class Livro extends Produto {
    private String autor;
    private String editora;
    private String isbn;
    private int ano;

    public Livro(int codigo, double preco, String descricao,
    // super chama o construtor da superclasse Produto.
                 String autor, String editora, String isbn, int ano) {
        super(codigo, preco, descricao);
        this.autor = autor;
        this.editora = editora;
        this.isbn = isbn;
        this.ano = ano;
    }

    public String getAutor() { return autor; }
    public String getEditora() { return editora; }
    public String getIsbn() { return isbn; }
    public int getAno() { return ano; }
// CompactDisc também herda da superclasse Produto.
}

class CompactDisc extends Produto {
    private String nomeAlbum;
    private String artista;
    private String gravadora;

    public CompactDisc(int codigo, double preco, String descricao,
                       String nomeAlbum, String artista, String gravadora) {
        super(codigo, preco, descricao);
        this.nomeAlbum = nomeAlbum;
        this.artista = artista;
        this.gravadora = gravadora;
    }

    public String getNomeAlbum() { return nomeAlbum; }
    public String getArtista() { return artista; }
    public String getGravadora() { return gravadora; }
}
