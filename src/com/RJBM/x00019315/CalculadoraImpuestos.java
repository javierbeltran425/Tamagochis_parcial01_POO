package com.RJBM.x00019315;

import java.util.Scanner;

final public class CalculadoraImpuestos {
    static Scanner scan = new Scanner(System.in);
    private double totalRenta;
    private double totalISSS;
    private double totalAFP;

    private CalculadoraImpuestos() {

    }

    public double calcularPago(Empleado p){
        System.out.println("Ingese el puesto del empleado: ");
        String puesto = scan.nextLine();

        if(puesto.equalsIgnoreCase("Servicio Profesional"))


    }

    public String mostrarTotales(){

    }
}
