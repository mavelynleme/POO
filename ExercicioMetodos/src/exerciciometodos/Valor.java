package exerciciometodos;

public class Valor {
    private int numero;

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public long calcularFatorial() {
        long fatorial = 1;

        for (int i = numero; i > 1; i--) {
            fatorial = fatorial * i;
        }

        return fatorial;
    }
}
