package exerciciometodos;

public class TesteFornecedor {
    public static void main(String[] args) {
        Fornecedor fornecedor1 = new Fornecedor(
                "Empresa Alpha",
                "Rua das Flores, 100",
                "123.456.789.000",
                "Joao Silva");

        Fornecedor fornecedor2 = new Fornecedor(
                "Empresa Beta",
                "Avenida Central, 250",
                "987.654.321.000",
                "Maria Souza");

        System.out.printf("FORNECEDOR 1%n");
        System.out.printf("Empresa: %s%n", fornecedor1.getEmpresa());
        System.out.printf("Endereco: %s%n", fornecedor1.getEndereco());
        System.out.printf("Inscricao Estadual: %s%n", fornecedor1.getInscricaoEstadual());
        System.out.printf("Nome do contato: %s%n%n", fornecedor1.getNomeContato());

        System.out.printf("FORNECEDOR 2%n");
        System.out.printf("Empresa: %s%n", fornecedor2.getEmpresa());
        System.out.printf("Endereco: %s%n", fornecedor2.getEndereco());
        System.out.printf("Inscricao Estadual: %s%n", fornecedor2.getInscricaoEstadual());
        System.out.printf("Nome do contato: %s%n", fornecedor2.getNomeContato());
    }
}
