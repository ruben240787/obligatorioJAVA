package com.mycompany.camping;

import java.util.InputMismatchException;
import java.util.Scanner;

public class verCamping {

    public static void main(String[] args) {
        //Escaner para ingresar los datos.
        Scanner scanner = new Scanner(System.in);
        // Hardcodeamos las cabañas.
        Cabania [] cabanias = { new Cabania ('a',"06/07/25", "07/07/25", 10,5,5000)};

        int cantPersonas = 0;
        boolean entradaValida = false;
        // solicitamos la cantidad de dias de estadia.
        System.out.print("Ingrese la cantidad de dias a alojarse: ");
        cabanias[1].setDiasEstadia(scanner.nextInt());

        while (!entradaValida) {
            try {
                System.out.print("Ingrese la cantidad de personas: ");            
                cantPersonas= scanner.nextInt();
                if (cantPersonas <= cabanias[1].maxPersonas && cantPersonas > 0) {
                    entradaValida = true;
                } else {
                    System.out.println("La cantidad debe ser entre 1 y " + cabanias[1].maxPersonas + ". Intente de nuevo.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor ingrese un número entero.");
                scanner.next();
            }
        }

        int total = cabanias[1].cobroEstadia(cantPersonas);
        System.out.println("El total a pagar por la estadía es: $" + total + " en la cabaña " + cabanias[1].nombre);
    }
}
