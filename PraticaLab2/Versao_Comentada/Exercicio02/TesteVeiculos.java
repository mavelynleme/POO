// Demonstra polimorfismo: array do tipo Veiculos recebe subclasses.
public class TesteVeiculos {
    public static void main(String[] args) {
        // O array tem exatamente quatro posições (índices de 0 a 3).
        Veiculos[] veiculos = new Veiculos[4];
        // Duas primeiras posições: Utilitarios.
        veiculos[0] = new Utilitarios("Toyota", "Hilux", 2023, 204, 1000, "Dupla");
        veiculos[1] = new Utilitarios("Fiat", "Strada", 2024, 107, 720, "Simples");
        // Duas últimas posições: Passageiros.
        veiculos[2] = new Passageiros("Honda", "Civic", 2022, 155, 450, 5);
        veiculos[3] = new Passageiros("Chevrolet", "Spin", 2023, 111, 500, 7);

        // A implementação chamada depende do objeto em cada posição.
        for (int i = 0; i < veiculos.length; i++) {
            veiculos[i].imprime();
        }
    }
}
