// Aplicação de teste: instancia um Livro e um CompactDisc.
public class TesteProdutos {
    public static void main(String[] args) {
        // Os valores de cada objeto são passados ao construtor.
        Livro livro = new Livro(1, 59.90, "Livro de Java",
                "Carlos Silva", "Editora ABC", "9781234567890", 2024);
        CompactDisc cd = new CompactDisc(2, 39.90, "CD de Rock",
                "Rock Classics", "Banda Exemplo", "Gravadora XYZ");

        // Os métodos get mostram os dados sem acessar atributos privados.
        System.out.println("=== LIVRO ===");
        System.out.println("Codigo: " + livro.getCodigo());
        System.out.println("Preco: " + livro.getPreco());
        System.out.println("Descricao: " + livro.getDescricao());
        System.out.println("Autor: " + livro.getAutor());
        System.out.println("Editora: " + livro.getEditora());
        System.out.println("ISBN: " + livro.getIsbn());
        System.out.println("Ano: " + livro.getAno());
        System.out.println();

        System.out.println("=== COMPACT DISC ===");
        System.out.println("Codigo: " + cd.getCodigo());
        System.out.println("Preco: " + cd.getPreco());
        System.out.println("Descricao: " + cd.getDescricao());
        System.out.println("Album: " + cd.getNomeAlbum());
        System.out.println("Artista: " + cd.getArtista());
        System.out.println("Gravadora: " + cd.getGravadora());
    }
}
