package com.RJBM.x00019315;

public class PlazaFija extends Empleado {
    private int extensión;

    public PlazaFija(String nombre, String puesto, double salario, int extension) {
        super(nombre, puesto, salario);
        this.extensión = extension;
    }

    public int getExtensión() {
        return extensión;
    }

    public void setExtensión(int extensión) {
        this.extensión = extensión;
    }
}
