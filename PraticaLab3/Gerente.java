public class Gerente extends Empregado {
    private double bonus;

    public Gerente(int codigo, String nome, double salarioBase, double bonus) {
        super(codigo, nome, salarioBase);
        this.bonus = bonus;
    }

    public double getBonus() { return bonus; }
    public void setBonus(double bonus) { this.bonus = bonus; }

    @Override
    public double CalculoSalario() {
        return getSalarioBase() + getBonus();
    }

    @Override
    public String toString() {
        return String.format("%s%nBônus: R$ %.2f", super.toString(), getBonus());
    }
}
