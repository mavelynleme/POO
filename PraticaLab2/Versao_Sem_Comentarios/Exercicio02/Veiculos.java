public abstract class Veiculos {
    protected String marca;
    protected String modelo;
    protected int ano;
    protected double potenciaMotor;
    protected double capacidadeCarga;

    public Veiculos(String marca, String modelo, int ano,
                    double potenciaMotor, double capacidadeCarga) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.potenciaMotor = potenciaMotor;
        this.capacidadeCarga = capacidadeCarga;
    }

    public abstract void imprime();
}

class Utilitarios extends Veiculos {
    private String tipoCabine;

    public Utilitarios(String marca, String modelo, int ano,
                      double potenciaMotor, double capacidadeCarga,
                      String tipoCabine) {
        super(marca, modelo, ano, potenciaMotor, capacidadeCarga);
        this.tipoCabine = tipoCabine;
    }

    @Override
    public void imprime() {
        System.out.println("=== UTILITARIO ===");
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Ano: " + ano);
        System.out.println("Potencia do motor: " + potenciaMotor);
        System.out.println("Capacidade de carga: " + capacidadeCarga);
        System.out.println("Tipo de cabine: " + tipoCabine);
        System.out.println();
    }
}

class Passageiros extends Veiculos {
    private int quantidadePassageiros;

    public Passageiros(String marca, String modelo, int ano,
                       double potenciaMotor, double capacidadeCarga,
                       int quantidadePassageiros) {
        super(marca, modelo, ano, potenciaMotor, capacidadeCarga);
        this.quantidadePassageiros = quantidadePassageiros;
    }

    @Override
    public void imprime() {
        System.out.println("=== PASSAGEIROS ===");
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Ano: " + ano);
        System.out.println("Potencia do motor: " + potenciaMotor);
        System.out.println("Capacidade de carga: " + capacidadeCarga);
        System.out.println("Quantidade de passageiros: " + quantidadePassageiros);
        System.out.println();
    }
}
