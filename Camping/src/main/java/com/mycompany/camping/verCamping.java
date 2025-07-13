package com.mycompany.camping;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class VerCamping {

    private static Cabania[] cabanias = {
        new Cabania('A', null, null, null, 0, 5, 5000, true),
        new Cabania('B', null, null, null, 0, 10, 10000, true),
        new Cabania('C', null, null, null, 0, 12, 12000, true)
    };

    private static Parcela[] parcelas = {
        new Parcela(1, null, null, null, 0, 10, 200, true),
        new Parcela(2, null, null, null, 0, 12, 200, true),
        new Parcela(3, null, null, null, 0, 15, 200, true),
        new Parcela(4, null, null, null, 0, 18, 200, true)
    };

    private static TitularResponsable[] clientes = new TitularResponsable[5];
    private static int cantidadClientes = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 5) {
            mostrarMenu();
            opcion = Excepciones.leerEntero(scanner, "Seleccione una opción: ", 1, 5);

            switch (opcion) {
                case 1:
                    ingresarCliente(scanner);
                    break;
                case 2:
                    verDatosCliente(scanner);
                    break;
                case 3:
                    mostrarDisponibilidad();
                    break;
                case 4:
                    mostrarOcupadas();
                    break;
                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n------------------------------");
        System.out.println("--- ADMINISTRACION CAMPING ---");
        System.out.println("------------------------------");
        System.out.println("1. Ingresar cliente");
        System.out.println("2. Ver datos del cliente");
        System.out.println("3. Ver disponibilidad");
        System.out.println("4. Ver alojamientos ocupados");
        System.out.println("5. Salir");
    }

    private static void ingresarCliente(Scanner scanner) {
        if (cantidadClientes >= clientes.length) {
            System.out.println("Capacidad máxima de clientes alcanzada.");
            return;
        }

        System.out.println("\n--- INGRESO DE NUEVO CLIENTE ---");

        TitularResponsable nuevoCliente = new TitularResponsable("", "0", "0", "", 0);

        scanner.nextLine();

        System.out.print("Ingrese nombre del cliente: ");
        nuevoCliente.setNombreCompleto(scanner.nextLine());

        System.out.print("Ingrese número de documento del cliente: ");
        nuevoCliente.setNumeroDoc(scanner.nextLine());

        System.out.print("Ingrese los últimos 8 dígitos de la tarjeta: ");
        while (!scanner.hasNextInt()) {
            System.out.print("Debe ingresar solo números. Intente nuevamente: ");
            scanner.next();
        }
        nuevoCliente.setNumeroTarjeta(scanner.nextInt());
        scanner.nextLine();

        System.out.print("Ingrese número de teléfono: ");
        nuevoCliente.setNumeroTelefono(scanner.nextLine());

        System.out.print("Nacionalidad: ");
        String nacionalidad = scanner.next().toLowerCase(); // Convertir a minúsculas para comparación sin case sensitive

        if (nacionalidad.contains("uru")) {
            nuevoCliente.setUruguayo("Uruguayo");
        } else {
            nuevoCliente.setUruguayo("Otra nacionalidad");
        }

        System.out.println("\nSeleccione tipo de alojamiento:");
        System.out.println("1. Cabaña");
        System.out.println("2. Parcela");

        int tipoAlojamiento = Excepciones.leerEntero(scanner, "Opción: ", 1, 2);
        if (tipoAlojamiento == 1) {
            seleccionarCabania(scanner, nuevoCliente);
        } else {
            seleccionarParcela(scanner, nuevoCliente);
        }

        clientes[cantidadClientes] = nuevoCliente;
        cantidadClientes++;

        System.out.println("¡Cliente registrado exitosamente!");
    }

    private static void seleccionarCabania(Scanner scanner, TitularResponsable cliente) {
        int disponibles = 0;
        for (Cabania cabania : cabanias) {
            if (cabania.disponible) {
                disponibles++;
            }
        }
        if (disponibles == 0) {
            System.out.println("No hay cabañas disponibles.");
            return;
        }

        int mostradas = 0;
        for (Cabania cabania : cabanias) {
            if (cabania.disponible) {
                System.out.println((mostradas + 1) + ". Cabaña " + cabania.nombre
                        + " - Capacidad: " + cabania.maxPersonas
                        + " - Precio: $" + cabania.precioPorDia);
                mostradas++;
            }
        }

        int seleccion = Excepciones.leerEntero(scanner, "Seleccione una cabaña: ", 1, disponibles) - 1;
        int index = 0;
        for (Cabania cabania : cabanias) {
            if (cabania.disponible) {
                if (index == seleccion) {
                    cabania.disponible = false;
                    cabania.entrada = LocalDate.now();

                    System.out.println("Ingrese Fecha estimada de Salida (dd/MM/yyyy):");
                    LocalDate salida = verificarFecha();

                    while (!salida.isAfter(cabania.entrada)) {
                        System.out.println("La fecha debe ser posterior a hoy. Intente nuevamente:");
                        salida = verificarFecha();
                    }

                    cabania.salida = salida;
                    int dias = (int) ChronoUnit.DAYS.between(cabania.entrada, salida);
                    cabania.setDiasEstadia(dias);

                    int personas;
                    do {
                        personas = Excepciones.leerEntero(scanner,
                                "Ingrese la cantidad de personas (máximo " + cabania.maxPersonas + "): ",
                                1, cabania.maxPersonas);
                    } while (personas > cabania.maxPersonas);
                    cabania.cliente = cliente;
                    break;
                }
                index++;
            }
        }
    }

    private static void seleccionarParcela(Scanner scanner, TitularResponsable cliente) {
        int disponibles = 0;
        for (Parcela parcela : parcelas) {
            if (parcela.disponible) {
                disponibles++;
            }
        }
        if (disponibles == 0) {
            System.out.println("No hay parcelas disponibles.");
            return;
        }

        int mostradas = 0;
        for (Parcela parcela : parcelas) {
            if (parcela.disponible) {
                System.out.println((mostradas + 1) + ". Parcela " + parcela.identificador
                        + " - Capacidad: " + parcela.maxPersonas
                        + " - Precio: $" + parcela.precioPorDia);
                mostradas++;
            }
        }

        int seleccion = Excepciones.leerEntero(scanner, "Seleccione una parcela: ", 1, disponibles) - 1;
        int index = 0;
        for (Parcela parcela : parcelas) {
            if (parcela.disponible) {
                if (index == seleccion) {
                    parcela.disponible = false;
                    parcela.entrada = LocalDate.now();
                    scanner.next();

                    System.out.println("Ingrese Fecha estimada de Salida (dd/MM/yyyy):");
                    LocalDate salida = verificarFecha();

                    while (!salida.isAfter(parcela.entrada)) {
                        System.out.println("La fecha debe ser posterior a hoy. Intente nuevamente:");
                        salida = verificarFecha();
                    }

                    parcela.salida = salida;
                    int dias = (int) ChronoUnit.DAYS.between(parcela.entrada, salida);
                    parcela.setDiasEstadia(dias);

                    int personas;
                    do {
                        personas = Excepciones.leerEntero(scanner,
                                "Ingrese la cantidad de personas (máximo " + parcela.maxPersonas + "): ",
                                1, parcela.maxPersonas);
                    } while (personas > parcela.maxPersonas);
                    parcela.cliente = cliente;
                    break;
                }
                index++;
            }
        }
    }

    private static void verDatosCliente(Scanner scanner) {
        if (cantidadClientes == 0) {
            System.out.println("\nNo hay clientes registrados.");
            return;
        }

        System.out.println("\nSeleccione un cliente:");
        for (int i = 0; i < cantidadClientes; i++) {
            System.out.println((i + 1) + ". " + clientes[i].getNombreCompleto());
        }

        int seleccion = Excepciones.leerEntero(scanner, "Seleccione un cliente: ", 1, cantidadClientes);
        TitularResponsable clienteSeleccionado = clientes[seleccion - 1];

        System.out.println("\n--- DATOS DEL CLIENTE ---");
        System.out.println(clienteSeleccionado);

        for (Cabania cabania : cabanias) {
            if (cabania.cliente != null
                    && cabania.cliente.getNumeroDoc().equals(clienteSeleccionado.getNumeroDoc())) {
                System.out.println("\n--- DATOS DE ALOJAMIENTO (CABAÑA) ---");
                System.out.println("Tipo: Cabaña " + cabania.nombre);
                System.out.println("Fecha de entrada: " + cabania.entrada.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                System.out.println("Fecha de salida: " + cabania.salida.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                System.out.println("Días de estadía: " + cabania.getDiasEstadia());
                System.out.println("Precio por día: $" + cabania.precioPorDia);
                System.out.println("Total a pagar: $" + cabania.cobroEstadia(cabania.getDiasEstadia()));
                return;
            }
        }

        for (Parcela parcela : parcelas) {
            if (parcela.cliente != null
                    && parcela.cliente.getNumeroDoc().equals(clienteSeleccionado.getNumeroDoc())) {
                System.out.println("\n--- DATOS DE ALOJAMIENTO (PARCELA) ---");
                System.out.println("Tipo: Parcela " + parcela.identificador);
                System.out.println("Fecha de entrada: " + parcela.entrada.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                System.out.println("Fecha de salida: " + parcela.salida.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                System.out.println("Días de estadía: " + parcela.getDiasEstadia());
                System.out.println("Precio por día: $" + parcela.precioPorDia);
                System.out.println("Total a pagar: $" + parcela.cobroEstadia(parcela.getDiasEstadia()));
                return;
            }
        }

        System.out.println("\nNo se encontró información de alojamiento para este cliente.");
    }

    private static LocalDate verificarFecha() {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true) {
            String entrada = scanner.nextLine().trim();
            if (entrada.isEmpty()) {
                System.out.println("Error: No se ingresó ninguna fecha. Intente nuevamente:");
                continue;
            }
            try {
                return LocalDate.parse(entrada, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Formato inválido. Use exactamente dd/MM/yyyy (ej: 25/12/2023). Intente nuevamente:");
            }
        }
    }

    private static void mostrarDisponibilidad() {
        System.out.println("\n--- DISPONIBILIDAD DE CABAÑAS ---");
        for (Cabania cabania : cabanias) {
            String estado = cabania.disponible ? "DISPONIBLE" : "OCUPADA";
            System.out.println("Cabaña " + cabania.nombre
                    + " - Capacidad: " + cabania.maxPersonas
                    + " - Precio/día: $" + cabania.precioPorDia
                    + " - Estado: " + estado);
        }

        System.out.println("\n--- DISPONIBILIDAD DE PARCELAS ---");
        for (Parcela parcela : parcelas) {
            String estado = parcela.disponible ? "DISPONIBLE" : "OCUPADA";
            System.out.println("Parcela " + parcela.identificador
                    + " - Capacidad: " + parcela.maxPersonas
                    + " - Precio/día: $" + parcela.precioPorDia
                    + " - Estado: " + estado);
        }
    }

    private static void mostrarOcupadas() {
        boolean hayOcupadas = false;

        System.out.println("\n--- CABAÑAS OCUPADAS ---");
        for (Cabania cabania : cabanias) {
            if (!cabania.disponible && cabania.cliente != null) {
                hayOcupadas = true;
                System.out.println("\nCabaña " + cabania.nombre
                        + " - Capacidad: " + cabania.maxPersonas
                        + " - Precio/día: $" + cabania.precioPorDia);
                System.out.println("Cliente: " + cabania.cliente.getNombreCompleto());
                System.out.println("Documento: " + cabania.cliente.getNumeroDoc());
                System.out.println("Teléfono: " + cabania.cliente.getNumeroTelefono());
                System.out.println("Entrada: " + cabania.entrada.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                System.out.println("Salida: " + cabania.salida.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                System.out.println("Días: " + cabania.getDiasEstadia());
                System.out.println("Total: $" + cabania.cobroEstadia(cabania.getDiasEstadia()));
            }
        }
        if (!hayOcupadas) {
            System.out.println("No hay cabañas ocupadas.");
        }

        hayOcupadas = false;
        System.out.println("\n--- PARCELAS OCUPADAS ---");
        for (Parcela parcela : parcelas) {
            if (!parcela.disponible && parcela.cliente != null) {
                hayOcupadas = true;
                System.out.println("\nParcela " + parcela.identificador
                        + " - Capacidad: " + parcela.maxPersonas
                        + " - Precio/día: $" + parcela.precioPorDia);
                System.out.println("Cliente: " + parcela.cliente.getNombreCompleto());
                System.out.println("Documento: " + parcela.cliente.getNumeroDoc());
                System.out.println("Teléfono: " + parcela.cliente.getNumeroTelefono());
                System.out.println("Entrada: " + parcela.entrada.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                System.out.println("Salida: " + parcela.salida.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                System.out.println("Días: " + parcela.getDiasEstadia());
                System.out.println("Total: $" + parcela.cobroEstadia(parcela.getDiasEstadia()));
            }
        }
        if (!hayOcupadas) {
            System.out.println("No hay parcelas ocupadas.");
        }
    }
}
