public class FuncionarioComissao extends Funcionario {
    private double vendaBruta;
    private double comissao;

    public FuncionarioComissao(String nome, String sobrenome, String cpf,
                               double vendaBruta, double comissao) {
        super(nome, sobrenome, cpf);
        setVendaBruta(vendaBruta);
        setComissao(comissao);
    }

    public double getVendaBruta() { return vendaBruta; }
    public double getComissao() { return comissao; }

    public void setVendaBruta(double vendaBruta) {
        this.vendaBruta = (vendaBruta < 0) ? 0 : vendaBruta;
    }

    public void setComissao(double comissao) {
        this.comissao = (comissao > 0 && comissao < 1) ? comissao : 0;
    }

    @Override
    public double salario() {
        return getVendaBruta() * getComissao();
    }

    @Override
    public String toString() {
        return String.format("%s%nVenda bruta: R$ %.2f%nComissão: %.2f",
                super.toString(), getVendaBruta(), getComissao());
    }
}
