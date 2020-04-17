package com.RJBM.x00019315;

import java.util.Scanner;

public class Main {
    static  Scanner in = new Scanner(System.in);
    public static void main(String[] args) {

        boolean continuar = true;
        int opción = 0;
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
                    break;
                case 3:
                    listaEmpleados();
                    break;
                case 4:
                    break;
                case 5:
                    break;
                default: System.out.print("Opción incorrecta");
            }

        }while(continuar);
    }

    public static void addEmpleado(){
        Empleado persona = null;
        System.out.println("**********************************");
        System.out.println(" Sistema de registro de empleados");
        System.out.println("**********************************");

        System.out.print("Ingrese el nombre del empleado: ");
        persona.nombre = in.nextLine();
        System.out.print("\nIngrese el puesto a desempeñar: ");
        persona.puesto = in.nextLine();
        System.out.print("\nIngrese el salario de este empleado: ");
        persona.salario = in.nextInt(); in.nextLine();

        Empresa.addEmpleado(persona);
    }

    public static void listaEmpleados(){
        Empresa e = null;
        System.out.print(e.getPlanilla());
    }
}