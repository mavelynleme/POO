// Coloca a classe de teste no pacote comentados.
package comentados;

// Classe usada para testar as quatro sobrecargas do metodo adiciona.
public class TesteSobrecargaComentada {
    // Ponto de entrada da aplicacao Java.
    public static void main(String[] args) {
        // new cria dois objetos distintos, ambos pertencentes a mesma classe.
        // Cada variavel guarda a referencia para sua propria instancia.
        SobrecargaComentada objeto1 = new SobrecargaComentada();
        SobrecargaComentada objeto2 = new SobrecargaComentada();

        System.out.printf("OBJETO 1%n");
        // Java escolhe adiciona(int, int) pelos dois argumentos inteiros.
        objeto1.adiciona(10, 20);
        // Tres argumentos inteiros selecionam adiciona(int, int, int).
        objeto1.adiciona(10, 20, 30);
        // Dois argumentos reais selecionam adiciona(double, double).
        objeto1.adiciona(10.5, 20.5);
        // Dois textos selecionam adiciona(String, String).
        objeto1.adiciona("Joao", "Silva");

        System.out.printf("%nOBJETO 2%n");
        // As quatro chamadas sao repetidas para o segundo objeto.
        objeto2.adiciona(5, 15);
        objeto2.adiciona(5, 15, 25);
        objeto2.adiciona(5.5, 15.5);
        objeto2.adiciona("Maria", "Souza");
        // Ao todo, existem oito chamadas ao metodo adiciona.
    }
}
