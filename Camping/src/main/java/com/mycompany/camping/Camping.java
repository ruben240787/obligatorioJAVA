package com.mycompany.camping;

import java.time.LocalDate;

public abstract class Camping {

    LocalDate entrada;
    LocalDate salida;
    int diasEstadia;
    int maxPersonas;
    int precioPorDia;
    boolean disponible;

    public Camping(LocalDate entrada, LocalDate salida, int diasEstadia, int maxPersonas, int precioPorDia, boolean disponible) {
        this.entrada = entrada;
        this.salida = salida;
        this.diasEstadia = diasEstadia;
        this.maxPersonas = maxPersonas;
        this.precioPorDia = precioPorDia;
        this.disponible=disponible;
    }
    //Funcion abstracta para que sea implementada por herencia
    public abstract int cobroEstadia(int cantPersonas);
}
