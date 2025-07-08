package com.mycompany.camping;

import java.time.LocalDate;
import java.util.Scanner;

public class verCamping {

    public static void main(String[] args) {
        //Escaner para ingresar los datos.
        Scanner scanner = new Scanner(System.in);
        // Hardcodeamos las cabañas.
        Cabania[] cabanias = {
            new Cabania('A', null, null, 0, 5, 5000),
            new Cabania('B', null, null, 0, 10, 10000),
            new Cabania('C', null, null, 0, 12, 12000)
        };
        //Hardcodeamos las parcelas.
        Parcelas[] parcela = {
            new Parcelas(1, null, null, 0, 10, 200),
            new Parcelas(2, null, null, 0, 12, 200),
            new Parcelas(3, null, null, 0, 15, 200),
            new Parcelas(4, null, null, 0, 18, 200)
        };

        // Clase Persona.
        TitularResponsable cliente1 = new TitularResponsable("", "0", "0", true, 0);

        //Inicio del Programa
        System.out.println("------------------------------");
        System.out.println("--- ADMINISTRACION CAMPING ---");
        System.out.println("------------------------------\n");

        System.out.println("Ingrese Nombre del cliente");
        cliente1.setNombreCompleto(scanner.nextLine());
        
        System.out.println("Ingrese donde se va a alojar");
        
        
        
        
        
        
        
        
        
        
        
        // Definimos la fcha de entrada como la de hoy.
        cabanias[0].entrada= LocalDate.now();  
        
        
        
        
        
        System.out.println("Ingrese Fecha estimada de Salida");
        LocalDate fechaValida = verificarFecha(scanner);
            public LocalDate verificarFecha(Scanner scanner) {
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
        

        
        
        cabanias[0].salida= fechaSalida;
        
        
        
        
        
        
        

        System.out.println("Ingrese numero de documento del cliente");
        cliente1.setNumeroDoc(scanner.nextLine());

        System.out.println("Ingrese ingrese numero de tarjeta");
        cliente1.setNumeroTarjeta(scanner.nextInt());

        System.out.println("Ingrese numero de telefono");
        cliente1.setNumeroTelefono(scanner.nextLine());

        // solicitamos la cantidad de dias que se va a alojar.
        System.out.println("Ingrese la cantidad de dias a alojarse: ");
        cabanias[0].setDiasEstadia(scanner.nextInt());

        // Consultamos y comporbamos que la cantidad de personas a alojrse no supere la maxima que permite la cabaña.        
        int cantPersonas = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            cantPersonas = Excepciones.leerEntero(scanner, "Ingrese la cantidad de personas a alojarse: ");
            if (cantPersonas > 0 && cantPersonas <= cabanias[0].maxPersonas) {
                entradaValida = true;
            } else {
                System.out.println("La capacidad máxima de la cabaña es " + cabanias[0].maxPersonas + ". Intente de nuevo.");
            }
        }

        //Llamamos a la funcion cobroEstadia para mostar por pantalla el monto total a cobrar.
        int total = cabanias[0].cobroEstadia(cantPersonas);
        System.out.println("El total a pagar por la estadía es: $" + total + " en la cabaña " + cabanias[0].nombre);
        System.out.println("Datos del Responsable " + cliente1);
    }
}
