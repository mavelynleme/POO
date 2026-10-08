// Classe abstrata: não permite criar objetos Veiculos diretamente.
public abstract class Veiculos {
    // protected permite o acesso aos atributos nas subclasses.
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
    // As subclasses são obrigadas a implementar imprime().

    public abstract void imprime();
}
// Utilitarios herda de Veiculos e adiciona o tipo da cabine.

class Utilitarios extends Veiculos {
    private String tipoCabine;

    public Utilitarios(String marca, String modelo, int ano,
                      double potenciaMotor, double capacidadeCarga,
                      String tipoCabine) {
        super(marca, modelo, ano, potenciaMotor, capacidadeCarga);
    // O construtor da classe pai é chamado com super(...).
        this.tipoCabine = tipoCabine;
    }

    @Override
    public void imprime() {
    // Sobrescrita do método abstrato para mostrar os dados do utilitário.
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

// Passageiros também herda de Veiculos.
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
    // Implementação específica de imprime() para passageiros.
        System.out.println("Potencia do motor: " + potenciaMotor);
        System.out.println("Capacidade de carga: " + capacidadeCarga);
        System.out.println("Quantidade de passageiros: " + quantidadePassageiros);
        System.out.println();
    }
}
