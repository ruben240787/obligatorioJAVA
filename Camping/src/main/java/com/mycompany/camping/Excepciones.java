package com.mycompany.camping;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Excepciones {

    Scanner scanner = new Scanner(System.in);

    // Método para leer un número entero validado
    public static int leerEntero(Scanner scanner, String mensaje) {
        int numero = 0;
        boolean valido = false;

        while (!valido) {
            try {
                System.out.print(mensaje);
                numero = scanner.nextInt();
                valido = true;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor ingrese un número entero.");
                scanner.next(); // limpia el buffer
            }
        }

        return numero;
    }

    public static LocalDate verificarFecha(Scanner scanner) {
        while (true) {
            String entrada = scanner.nextLine().trim();

            if (entrada.isEmpty()) {
                System.out.println("Error: No se ingresó ninguna fecha.");
                continue;
            }

            try {
                return LocalDate.parse(entrada,
                        java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            } catch (DateTimeParseException e) {
                System.out.println("Error: Formato de fecha inválido. Use dd/MM/yyyy.");
            }
        }
    }

}
