public class AplicacaoEmpregado {
    public static void main(String[] args) {
        Engenheiro eng = new Engenheiro(1, "Carlos Silva", 5000.00, "Obras", "CREA-SP 12345");
        Gerente ger = new Gerente(2, "Ana Souza", 7000.00, 1500.00);

        System.out.printf("=== Engenheiro ===%n%s%n", eng.toString());
        System.out.printf("Salário calculado: R$ %.2f%n%n", eng.CalculoSalario());

        System.out.printf("=== Gerente ===%n%s%n", ger.toString());
        System.out.printf("Salário calculado: R$ %.2f%n", ger.CalculoSalario());
    }
}
