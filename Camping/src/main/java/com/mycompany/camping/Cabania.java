package com.mycompany.camping;

public class Cabania extends Camping {

    char nombre;

    public Cabania(char nombre, String entrada, String salida, int diasEstadia, int maxPersonas, int precioPorDia) {
        super(entrada, salida, diasEstadia, maxPersonas, precioPorDia);
        this.nombre = nombre;
    }
    
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

    public char getNombre() {
        return nombre;
    }

    public String getEntrada() {
        return entrada;
    }

    public String getSalida() {
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

    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }

    public void setSalida(String salida) {
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

    
}
