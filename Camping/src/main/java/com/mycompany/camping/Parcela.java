
package com.mycompany.camping;

import java.time.LocalDate;


public class Parcela extends Camping {
    //Atrubuto unico de la clase.
    int identificador;
    TitularResponsable cliente;
    //Contructor.

    public Parcela(int identificador, TitularResponsable cliente, LocalDate entrada, LocalDate salida, int diasEstadia, int maxPersonas, int precioPorDia, boolean disponible) {
        super(entrada, salida, diasEstadia, maxPersonas, precioPorDia, disponible);
        this.identificador = identificador;
        this.cliente = cliente;
    }

    //Funcion para determinar el cobro de la estadia en la parcela
    @Override
      public int cobroEstadia(int cantPersonas) {
        int cobro=0;
        if (cantPersonas <= maxPersonas) {
            cobro = cantPersonas * precioPorDia;
        } else{
            System.out.println("La personas ingredadas superan el maximo permitido");
        }
        return cobro * diasEstadia;
    }       
    //Getter y Setter.

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public void setCliente(TitularResponsable cliente) {
        this.cliente = cliente;
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

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public int getIdentificador() {
        return identificador;
    }

    public TitularResponsable getCliente() {
        return cliente;
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

    public boolean isDisponible() {
        return disponible;
    }


    
        @Override
    public String toString() {
        return "Parcela  " + "N° de identificacion : " + identificador
                + " con una capacidad maxima de "+ maxPersonas + " personas y un valor por persona de de $" + precioPorDia;
    }
    
}
