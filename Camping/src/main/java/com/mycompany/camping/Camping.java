package com.mycompany.camping;

public abstract class Camping {

    String entrada;
    String salida;
    int diasEstadia;
    int maxPersonas;
    int precioPorDia;

    public Camping(String entrada, String salida, int diasEstadia, int maxPersonas, int precioPorDia) {
        this.entrada = entrada;
        this.salida = salida;
        this.diasEstadia = diasEstadia;
        this.maxPersonas = maxPersonas;
        this.precioPorDia = precioPorDia;}


    //Funcion abstracta para que sea implementada por herencia
    public abstract int cobroEstadia(int cantPersonas);
    

}
