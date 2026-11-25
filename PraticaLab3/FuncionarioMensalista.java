public class FuncionarioMensalista extends Funcionario {
    private double salarioMensal;

    public FuncionarioMensalista(String nome, String sobrenome, String cpf, double salarioMensal) {
        super(nome, sobrenome, cpf);
        setSalarioMensal(salarioMensal);
    }

    public double getSalarioMensal() { return salarioMensal; }

    public void setSalarioMensal(double salarioMensal) {
        this.salarioMensal = (salarioMensal < 0) ? 0 : salarioMensal;
    }

    @Override
    public double salario() {
        return getSalarioMensal();
    }

    @Override
    public String toString() {
        return String.format("%s%nSalário mensal: R$ %.2f", super.toString(), getSalarioMensal());
    }
}
