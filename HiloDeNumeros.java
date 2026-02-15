import java.util.Scanner;

public class HiloDeNumeros {

    static class GeneradorNumeros implements Runnable {

        private int limiteNumerico;

        public GeneradorNumeros(int limiteNumerico) {
            this.limiteNumerico = limiteNumerico;
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
    }

    public static void main(String[] args) {

        Scanner lector = new Scanner(System.in);
        String entrada;
        int limite;

        while (true) {
            System.out.print("Ingrese el numero desde el que desea iniciar el conteo regresivo: ");
            entrada = lector.next();

            if (entrada.matches("\\d+")) {
                limite = Integer.parseInt(entrada);
                break;
            } else {
                System.out.println("Solo se permiten numeros.");
            }
        }

        GeneradorNumeros tarea = new GeneradorNumeros(limite);
        Thread hilo = new Thread(tarea);
        hilo.start();

        lector.close();
    }
}
