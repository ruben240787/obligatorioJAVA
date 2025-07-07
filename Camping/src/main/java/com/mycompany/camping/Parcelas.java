
package com.mycompany.camping;


public class Parcelas extends Camping {
    int identificador;    

    public Parcelas(int identificador, String entrada, String salida, int diasEstadia, int maxPersonas, int precioPorDia) {
        super(entrada, salida, diasEstadia, maxPersonas, precioPorDia);
        this.identificador = identificador;
    }


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

    public int getIdentificador() {
        return identificador;
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

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
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
