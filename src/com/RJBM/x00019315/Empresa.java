package com.RJBM.x00019315;

import java.util.ArrayList;
import java.util.Scanner;

public class Empresa {
    static Scanner in = new Scanner(System.in);
    private static String nombre;
    private static ArrayList<Empleado> planilla;

    public Empresa(String nombre, ArrayList<Empleado> planilla) {
        this.nombre = nombre;
        this.planilla = planilla;
        planilla = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Empleado> getPlanilla() {
        return planilla;
    }

   static public void addEmpleado(Empleado persona){
        System.out.println("**********************************");
        System.out.println(" Sistema de registro de empleados");
        System.out.println("**********************************");

        System.out.print("Ingrese el nombre del empleado: ");
        persona.nombre = in.nextLine();
        System.out.print("\nIngrese el puesto a desempeñar: ");
        persona.puesto = in.nextLine();
        System.out.print("\nIngrese el salario de este empleado: ");
        persona.salario = in.nextInt(); in.nextLine();

        planilla.add(persona);
    }

    static public void quitEmpleado(String nombre){
        System.out.println("Ingrese el nombre del empleado a despedir: ");
        nombre = in.nextLine();

        for (Empleado aux: planilla) {
            if(aux.getNombre().equals(nombre)){
                planilla.remove(aux);
                System.out.print("El empleado a sido despedido");
            }
        }
    }
}
