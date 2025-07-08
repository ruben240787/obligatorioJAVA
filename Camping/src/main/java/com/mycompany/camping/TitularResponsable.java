
package com.mycompany.camping;

public class TitularResponsable {
    String nombreCompleto;
    String numeroDoc;
    String numeroTelefono;
    boolean uruguayo;
    int numeroTarjeta;

    public TitularResponsable(String nombreCompleto, String numeroDoc, String numeroTelefono, boolean uruguayo, int numeroTarjeta) {
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

    public boolean isUruguayo() {
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

    public void setUruguayo(boolean uruguayo) {
        this.uruguayo = uruguayo;
    }

    public void setNumeroTarjeta(int numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    @Override
    public String toString() {
        return "TitularResponsable " + " Nombre = " + nombreCompleto + ", Doc.: " + numeroDoc + ", Telefono: " + numeroTelefono
                + ", Uruguayo: " + uruguayo + " Tarjeta N° " + numeroTarjeta;
    }
    
    
    
    
}
