
import helpers.InputValidator;
import threads.GeneradorNumeros;
import threads.MostrarAlfabeto;
import java.util.Scanner;

/**
 * Clase principal de la aplicación de hilos concurrentes.
 * Coordina la ejecución de dos hilos simultáneos.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Obtener datos del usuario
        int numeroInicial = InputValidator.validarNumeroInicial(scanner);
        char letraFinal = InputValidator.validarLetraFinal(scanner);
        scanner.close();

        // Mostrar encabezado
        System.out.println("\n" + "=".repeat(60));
        System.out.println("INICIANDO APLICACIÓN DE HILOS");
        System.out.println("=".repeat(60));
        System.out.println("Hilo 1: Conteo regresivo desde " + numeroInicial + " (500ms)");
        System.out.println("Hilo 2: Alfabeto desde A hasta " + letraFinal + " (600ms)");
        System.out.println("=".repeat(60) + "\n");

        // Crear y ejecutar hilos
        Thread hiloContador = new Thread(new GeneradorNumeros(numeroInicial));
        Thread hiloAlfabeto = new Thread(new MostrarAlfabeto(letraFinal));

        hiloContador.start();
        hiloAlfabeto.start();

        // Esperar a que terminen
        try {
            hiloContador.join();
            hiloAlfabeto.join();
        } catch (InterruptedException e) {
            System.err.println("Error: " + e.getMessage());
        }

        // Mensaje final
        System.out.println("\n" + "=".repeat(60));
        System.out.println("APLICACIÓN FINALIZADA");
        System.out.println("=".repeat(60));
    }
}