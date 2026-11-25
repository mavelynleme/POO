public class Engenheiro extends Empregado {
    private String departamento;
    private String crea;

    public Engenheiro(int codigo, String nome, double salarioBase, String departamento, String crea) {
        super(codigo, nome, salarioBase);
        this.departamento = departamento;
        this.crea = crea;
    }

    public String getDepartamento() { return departamento; }
    public void setDepartamento(String departamento) { this.departamento = departamento; }

    public String getCrea() { return crea; }
    public void setCrea(String crea) { this.crea = crea; }

    @Override
    public double CalculoSalario() {
        return getSalarioBase() * 1.5; // salário base + 50%
    }

    @Override
    public String toString() {
        return String.format("%s%nDepartamento: %s%nCREA: %s",
                super.toString(), getDepartamento(), getCrea());
    }
}
