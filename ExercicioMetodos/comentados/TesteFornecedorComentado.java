// Indica o pacote ao qual a classe pertence.
package comentados;

// Classe de teste dos objetos FornecedorComentado.
public class TesteFornecedorComentado {
    // Metodo principal onde a execucao do programa comeca.
    public static void main(String[] args) {
        // new chama o construtor e cria a primeira instancia.
        // Uma instancia e um objeto concreto criado a partir do modelo da classe.
        // Os quatro argumentos inicializam os quatro atributos pelo construtor.
        FornecedorComentado fornecedor1 = new FornecedorComentado(
                "Empresa Alpha",
                "Rua das Flores, 100",
                "123.456.789.000",
                "Joao Silva");

        // Cria uma segunda instancia independente da mesma classe.
        // Existem dois objetos porque o exercicio representa dois fornecedores.
        FornecedorComentado fornecedor2 = new FornecedorComentado(
                "Empresa Beta",
                "Avenida Central, 250",
                "987.654.321.000",
                "Maria Souza");

        // printf exibe texto formatado, e %n muda para a proxima linha.
        System.out.printf("FORNECEDOR 1%n");
        // %s marca o lugar em que uma String sera impressa.
        // Os getters recuperam os dados privados do primeiro objeto.
        System.out.printf("Empresa: %s%n", fornecedor1.getEmpresa());
        System.out.printf("Endereco: %s%n", fornecedor1.getEndereco());
        System.out.printf("Inscricao Estadual: %s%n", fornecedor1.getInscricaoEstadual());
        System.out.printf("Nome do contato: %s%n%n", fornecedor1.getNomeContato());

        // Os mesmos getters agora recuperam os dados da segunda instancia.
        System.out.printf("FORNECEDOR 2%n");
        System.out.printf("Empresa: %s%n", fornecedor2.getEmpresa());
        System.out.printf("Endereco: %s%n", fornecedor2.getEndereco());
        System.out.printf("Inscricao Estadual: %s%n", fornecedor2.getInscricaoEstadual());
        System.out.printf("Nome do contato: %s%n", fornecedor2.getNomeContato());
    }
}
