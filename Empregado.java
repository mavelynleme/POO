public abstract class Empregado {
    private int codigo;
    private String nome;
    private double salarioBase;

    public Empregado(int codigo, String nome, double salarioBase) {
        this.codigo = codigo;
        this.nome = nome;
        this.salarioBase = salarioBase;
    }

    public int getCodigo() { return codigo; }
    public void setCodigo(int codigo) { this.codigo = codigo; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public double getSalarioBase() { return salarioBase; }
    public void setSalarioBase(double salarioBase) { this.salarioBase = salarioBase; }

    public abstract double CalculoSalario();

    @Override
    public String toString() {
        return String.format("Código: %d%nNome: %s%nSalário base: R$ %.2f",
                getCodigo(), getNome(), getSalarioBase());
    }
}
