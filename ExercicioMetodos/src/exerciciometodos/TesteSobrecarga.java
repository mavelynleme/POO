package exerciciometodos;

public class TesteSobrecarga {
    public static void main(String[] args) {
        Sobrecarga objeto1 = new Sobrecarga();
        Sobrecarga objeto2 = new Sobrecarga();

        System.out.printf("OBJETO 1%n");
        objeto1.adiciona(10, 20);
        objeto1.adiciona(10, 20, 30);
        objeto1.adiciona(10.5, 20.5);
        objeto1.adiciona("Joao", "Silva");

        System.out.printf("%nOBJETO 2%n");
        objeto2.adiciona(5, 15);
        objeto2.adiciona(5, 15, 25);
        objeto2.adiciona(5.5, 15.5);
        objeto2.adiciona("Maria", "Souza");
    }
}
