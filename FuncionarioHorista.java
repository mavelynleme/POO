public class FuncionarioHorista extends Funcionario {
    private double salarioHora;
    private double numeroHoras;

    public FuncionarioHorista(String nome, String sobrenome, String cpf,
                              double salarioHora, double numeroHoras) {
        super(nome, sobrenome, cpf);
        setSalarioHora(salarioHora);
        setNumeroHoras(numeroHoras);
    }

    public double getSalarioHora() { return salarioHora; }
    public double getNumeroHoras() { return numeroHoras; }

    public void setSalarioHora(double salarioHora) {
        this.salarioHora = (salarioHora < 0) ? 0 : salarioHora;
    }

    public void setNumeroHoras(double numeroHoras) {
        this.numeroHoras = (numeroHoras > 0 && numeroHoras <= 168.0) ? numeroHoras : 0;
    }

    @Override
    public double salario() {
        if (getNumeroHoras() <= 40) {
            return getSalarioHora() * getNumeroHoras();
        } else {
            return 40 * getSalarioHora() + (getNumeroHoras() - 40) * getSalarioHora() * 1.5;
        }
    }

    @Override
    public String toString() {
        return String.format("%s%nSalário hora: R$ %.2f%nHoras trabalhadas: %.1f",
                super.toString(), getSalarioHora(), getNumeroHoras());
    }
}
