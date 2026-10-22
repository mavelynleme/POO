public class AplicacaoFuncionario {
    public static void main(String[] args) {
        FuncionarioMensalista mensalista =
                new FuncionarioMensalista("João", "Pereira", "111.111.111-11", 3500.00);
        FuncionarioHorista horista =
                new FuncionarioHorista("Maria", "Santos", "222.222.222-22", 25.00, 50);
        FuncionarioComissao comissionado =
                new FuncionarioComissao("Pedro", "Lima", "333.333.333-33", 20000.00, 0.10);

        System.out.printf("=== Mensalista ===%n%s%n", mensalista);
        System.out.printf("Salário: R$ %.2f%n%n", mensalista.salario());

        System.out.printf("=== Horista ===%n%s%n", horista);
        System.out.printf("Salário: R$ %.2f%n%n", horista.salario());

        System.out.printf("=== Comissionado ===%n%s%n", comissionado);
        System.out.printf("Salário: R$ %.2f%n", comissionado.salario());
    }
}
