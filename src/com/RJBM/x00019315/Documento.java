package com.RJBM.x00019315;


public class Documento {
    private String nombre;
    private String numero;

    public Documento(String nombre, String numero) {
        this.nombre = nombre;
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        System.out.println();
        return "\nDocumento" +
                "\nTipo de documento: " + nombre +
                "\nNúmero de documento:" + numero ;
    }
}
