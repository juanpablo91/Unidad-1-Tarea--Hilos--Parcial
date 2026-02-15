package threads;

/**
 * Hilo que muestra letras del alfabeto con temporización de 600ms.
 */
public class MostrarAlfabeto implements Runnable {

    private final char letraFinal;

    public MostrarAlfabeto(char letraFinal) {
        this.letraFinal = Character.toUpperCase(letraFinal);
    }

    @Override
    public void run() {
        try {
            // Mostrar letras desde A hasta letraFinal
            for (char letra = 'A'; letra <= letraFinal; letra++) {
                System.out.println("[HILO-ALFABETO] " + letra);
                Thread.sleep(600); // 600ms de espera
            }
            System.out.println("✓ Trabajo del hilo ALFABETO terminado");

        } catch (InterruptedException e) {
            System.err.println("El hilo ALFABETO fue interrumpido");
        }
    }
}

