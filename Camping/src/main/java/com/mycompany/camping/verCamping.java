package com.mycompany.camping;

import java.util.InputMismatchException;
import java.util.Scanner;

public class verCamping {

    public static void main(String[] args) {
        //Escaner para ingresar los datos.
        Scanner scanner = new Scanner(System.in);
        // Hardcodeamos las cabañas.
        Cabania [] cabanias = { new Cabania ('a',"", "", 10,5,5000)};
        
        // Clase Persona.
        TitularResponsable cliente1 = new TitularResponsable ("", "0","0", true, 0);
        
        
        //Inicio del Programa
        System.out.println("------------------------------");
        System.out.println("----ADMINISTRACION CAMPING----");
        System.out.println("------------------------------");
        System.out.println("");
        System.out.println("");
        
        
        System.out.print("Ingrese Nombre del cliente");
        cliente1.setNombreCompleto(scanner.nextLine());
        System.out.print("Ingrese Fecha de Ingreso   ej: 01/01/25");
        cabanias[0].setEntrada(scanner.nextLine());
        System.out.print("Ingrese Fecha estimada de Salida  ej: 01/01/25");
        cabanias[0].setSalida(scanner.nextLine());        
        System.out.print("Ingrese numero de documento del cliente");
        cliente1.setNumeroDoc(scanner.nextLine());
        System.out.print("Ingrese ingrese numero de tarjeta");
        cliente1.setNumeroTarjeta(scanner.nextInt());
        System.out.print("Ingrese numero de telefono");
        cliente1.setNumeroTelefono(scanner.nextLine());
        
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
        //Llamamos a la funcion cobroEstadia para mostar por pantalla el monto total a cobrar.
        int total = cabanias[1].cobroEstadia(cantPersonas);
        System.out.println("El total a pagar por la estadía es: $" + total + " en la cabaña " + cabanias[1].nombre);
        System.out.println("Datos del Responsable " + cliente1);
    }
}
