package threads;

/**
 * Hilo que genera una secuencia numérica ascendente
 * desde 1 hasta un límite definido.
 */
public class GeneradorNumeros implements Runnable {

    private final int limiteNumerico;

    public GeneradorNumeros(int limite) {
        if (limite <= 0) {
            throw new IllegalArgumentException(
                    "El límite debe ser mayor que 0: " + limite
            );
        }
        this.limiteNumerico = limite;
    }

    @Override
    public void run() {

        try {
            for (int i = limiteNumerico; i >= 0; i--) {
                System.out.println("Numero #: " + i);
                Thread.sleep(500); // pausa de 500 ms
            }

            System.out.println("¡Conteo finalizado!");

        } catch (InterruptedException e) {
            System.out.println("Hilo interrumpido.");
        }
    }

    public int getLimite() {
        return limiteNumerico;
    }
}

