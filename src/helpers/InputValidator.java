package helpers;

import java.util.Scanner;

/**
 * Clase para validar las entradas del usuario.
 */
public class InputValidator {

    /**
     * Valida y obtiene un número entero mayor a 0.
     */
    public static int validarNumeroInicial(Scanner scanner) {

        //
        int numero = -1;
        boolean valido = false;

        while (!valido) {
            try {
                System.out.print("Ingrese el número inicial para el conteo regresivo (mayor a 0): ");
                String input = scanner.nextLine().trim();

                if (input.isEmpty()) {
                    System.out.println("❌ Error: Debe ingresar un valor.\n");
                    continue;
                }

                numero = Integer.parseInt(input);

                if (numero <= 0) {
                    System.out.println("❌ Error: El número debe ser mayor a 0.\n");
                } else {
                    valido = true;
                }

            } catch (NumberFormatException e) {
                System.out.println("❌ Error: Debe ingresar un número entero válido.\n");
            }
        }

        return numero;
    }

    /**
     * Valida y obtiene una letra entre A y Z.
     */
    public static char validarLetraFinal(Scanner scanner) {
        char letra = ' ';
        boolean valido = false;

        while (!valido) {
            System.out.print("Ingrese la letra final del alfabeto (A-Z): ");
            String input = scanner.nextLine().trim().toUpperCase();

            if (input.isEmpty()) {
                System.out.println("❌ Error: Debe ingresar una letra.\n");
                continue;
            }

            if (input.length() != 1) {
                System.out.println("❌ Error: Debe ingresar solo una letra.\n");
                continue;
            }

            letra = input.charAt(0);

            if (letra < 'A' || letra > 'Z') {
                System.out.println("❌ Error: Debe ingresar una letra válida entre A y Z.\n");
            } else {
                valido = true;
            }
        }

        return letra;
    }
}