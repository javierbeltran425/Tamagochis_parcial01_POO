package com.RJBM.x00019315;

import java.util.ArrayList;
import java.util.Scanner;

final public class CalculadoraImpuestos {
    static Scanner scan = new Scanner(System.in);
    private double totalRenta;
    private double totalISSS;
    private double totalAFP;

    private CalculadoraImpuestos() {

    }

    public double calcularPago(Empleado p){
        double restante = 0;
        double pagoEmpleado = 0;
        if(p.getPuesto() == "Plaza fija"){
            totalAFP = p.salario * 0.0625;
            totalISSS = p.salario * 0.03;

            restante = p.salario - totalAFP - totalISSS;

            if(restante >= 0.01 && restante <= 472.00){
                totalRenta = 0;
            }else if (restante >= 472.01 && restante <= 895.24){
                totalRenta = 0.1 * (restante - 472) + 17.67;
            }else if (restante >= 895.25 && restante <= 2038.10){
                totalRenta = 0.2 * (restante - 895.24) + 60;
            }else if(restante >= 2038.11){
                totalRenta = 0.3 * (restante - 2038.10) + 288.57;
            }

            pagoEmpleado = restante - totalRenta;

        }else if(p.getPuesto() == "Servicio profesional"){
            totalRenta = 0.1 * p.salario;
            pagoEmpleado = p.salario - totalRenta;
        }

       return pagoEmpleado;
    }

    public String mostrarTotales(){
                return "CalculadoraImpuestos{" +
                        "totalRenta=" + totalRenta +
                        ", totalISSS=" + totalISSS +
                        ", totalAFP=" + totalAFP +
                        '}';
            }

}
