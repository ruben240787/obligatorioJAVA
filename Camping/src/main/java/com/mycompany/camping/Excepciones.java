package com.mycompany.camping;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Excepciones {
    // Método para leer un número entero validado
    public static int leerEntero(Scanner scanner, String mensaje, int par1, int maxPersonas) {
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
}
