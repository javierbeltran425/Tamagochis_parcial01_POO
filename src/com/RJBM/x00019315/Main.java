package com.RJBM.x00019315;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static  Scanner in = new Scanner(System.in);
    public static void main(String[] args) {

        String nombre = null;
        boolean continuar = true;
        int opción = 0;
        double sueldo = 0;
        System.out.println("*********************");
        System.out.println(" Sistema de empresa");
        System.out.println("*********************");

        do {
            System.out.print("1. Agregar empleado\n2. Despedir empleado\n 3. Ver lista de empleados\n4. Calcular sueldo\n5. Mostrar totales");

            switch (opción){
                case 1:
                    addEmpleado();
                    break;
                case 2:
                    quitEmpleado(nombre);
                    break;
                case 3:
                    listaEmpleados();
                    break;
                case 4:
                    ArrayList<Empleado> a = null;
                    Empresa p = null;
                    CalculadoraImpuestos b = null;

                    System.out.print("Ingrese el nombre de empleado: ");
                    nombre = in.nextLine();

                    a = p.getPlanilla();

                    for (Empleado aux : a) {
                        if(nombre.equals(aux)){
                            sueldo = b.calcularPago(aux);
                            System.out.print("Sueldo total: $" + sueldo);
                        }
                    }

                    break;
                case 5:
                    break;
                default: System.out.print("Opción incorrecta");
            }

        }while(continuar);
    }

    public static void addEmpleado(){
        Empleado persona = null;
        int opción = 0;
        System.out.println("**********************************");
        System.out.println(" Sistema de registro de empleados");
        System.out.println("**********************************");

        System.out.print("Ingrese el nombre del empleado: ");
        persona.nombre = in.nextLine();
        System.out.print("\nIngrese el puesto a desempeñar: " + "\n\t1. Plaza fija\n\t2. Servicio profesional");
        opción = in.nextInt(); in.nextLine();

        switch (opción){
            case 1:
                persona.puesto = "Plaza fija";
                break;
            case 2:
                persona.puesto = "Servicio profesional";
                break;
            default: System.out.print("Opción incorrecta");
        }
        
        System.out.print("\nIngrese el salario de este empleado: ");
        persona.salario = in.nextInt(); in.nextLine();

        Empresa.addEmpleado(persona);
    }

    public static void listaEmpleados(){
        Empresa e = null;
        System.out.print(e.getPlanilla());
    }

    public static void quitEmpleado(String nombre){
        try {
            if(nombre == null)
                throw new NotExistingEmployee("No existe tal empleado.");
            
            quitEmpleado(nombre);
        }
        catch (NotExistingEmployee ex){
            System.out.println(ex.getMessage());
        };
    }
}