package com.mycompany.camping;

import java.time.LocalDate;

public class Cabania extends Camping {
    //Atributo unico de la clase.
    char nombre;
    //Contructor.

    public Cabania(char nombre, LocalDate entrada, LocalDate salida, int diasEstadia, int maxPersonas, int precioPorDia) {
        super(entrada, salida, diasEstadia, maxPersonas, precioPorDia);
        this.nombre = nombre;
    }

    //Funcion para determinar el cobro de la estadia en la cabaña
    @Override
    public int cobroEstadia(int cantPersonas) {
        int cobro = 0;
        if (cantPersonas <= maxPersonas) {
            cobro = precioPorDia * diasEstadia;
        } else{
            System.out.println("La personas ingredadas superan el maximo permitido");
        }
        return cobro;
    }
    //Getter y Setter.

    public char getNombre() {
        return nombre;
    }

    public LocalDate getEntrada() {
        return entrada;
    }

    public LocalDate getSalida() {
        return salida;
    }

    public int getDiasEstadia() {
        return diasEstadia;
    }

    public int getMaxPersonas() {
        return maxPersonas;
    }

    public int getPrecioPorDia() {
        return precioPorDia;
    }

    public void setNombre(char nombre) {
        this.nombre = nombre;
    }

    public void setEntrada(LocalDate entrada) {
        this.entrada = entrada;
    }

    public void setSalida(LocalDate salida) {
        this.salida = salida;
    }

    public void setDiasEstadia(int diasEstadia) {
        this.diasEstadia = diasEstadia;
    }

    public void setMaxPersonas(int maxPersonas) {
        this.maxPersonas = maxPersonas;
    }

    public void setPrecioPorDia(int precioPorDia) {
        this.precioPorDia = precioPorDia;
    }
    

    @Override
    public String toString() {
        return "Cabania  " + "nombre : " + nombre + " con una capacidad maxima de "+ maxPersonas
                + " personas y un valor por dias de $" + precioPorDia;
    }
    

    
}
