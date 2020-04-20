package com.RJBM.x00019315;

final public class CalculadoraImpuestos {

    private static double totalRenta;
    private static double totalISSS;
    private static double totalAFP;

    CalculadoraImpuestos() {

    }

    public double calcularPago(Empleado p){
        double restante;
        double pagoEmpleado = 0;

        double rentaAux=0.00;
        double isssAux=0.00;
        double AFPAux=0.00;

        if(p.getPuesto() == "Plaza fija"){
            AFPAux = p.salario * 0.0625;
            isssAux = p.salario * 0.03;

            restante = p.salario - AFPAux - isssAux;

            if(restante >= 0.01 && restante <= 472.00){
                rentaAux = 0;
            }else if (restante >= 472.01 && restante <= 895.24){
                rentaAux = 0.1 * (restante - 472) + 17.67;
            }else if (restante >= 895.25 && restante <= 2038.10){
                rentaAux = 0.2 * (restante - 895.24) + 60;
            }else if(restante >= 2038.11){
                rentaAux = 0.3 * (restante - 2038.10) + 288.57;
            }

            pagoEmpleado = restante - rentaAux;

        }else if(p.getPuesto() == "Servicio profesional"){
            rentaAux= 0.1 * p.salario;
            pagoEmpleado = p.salario - rentaAux;
        }

        this.totalRenta = this.totalRenta + rentaAux;
        this.totalISSS = this.totalISSS + isssAux;
        this.totalAFP = this.totalAFP + AFPAux;


       return pagoEmpleado;
    }

    public String mostrarTotales(){
        System.out.println();
                return "Calculo de Impuestos \n" +
                        "Total de Renta: $" + this.totalRenta +
                        "\nTotal del ISSS: $" + this.totalISSS +
                        "\nTotal de AFP: $" + this.totalAFP;
            }
}
