
package com.mycompany.camping;

public class TitularResponsable {
    String nombreCompleto;
    String numeroDoc;
    String numeroTelefono;
    String uruguayo;
    int numeroTarjeta;

    public TitularResponsable(String nombreCompleto, String numeroDoc, String numeroTelefono, String uruguayo, int numeroTarjeta) {
        this.nombreCompleto = nombreCompleto;
        this.numeroDoc = numeroDoc;
        this.numeroTelefono = numeroTelefono;
        this.uruguayo = uruguayo;
        this.numeroTarjeta = numeroTarjeta;
    }
    
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getNumeroDoc() {
        return numeroDoc;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public String isUruguayo() {
        return uruguayo;
    }

    public int getNumeroTarjeta() {
        return numeroTarjeta;
    }
    
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public void setNumeroDoc(String numeroDoc) {
        this.numeroDoc = numeroDoc;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public void setUruguayo(String uruguayo) {
        this.uruguayo = uruguayo;
    }

    public void setNumeroTarjeta(int numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    @Override
    public String toString() {
        return "TitularResponsable " + " Nombre = " + nombreCompleto + ", Doc.: " + numeroDoc + ", Telefono: " + numeroTelefono
                + ", Nacionalidad: " + uruguayo + " Tarjeta N° " + numeroTarjeta;
    }    
}
