package com.RJBM.x00019315;

import java.util.ArrayList;
import java.util.Scanner;

public class Empresa {
    static Scanner in = new Scanner(System.in);
    private String nombre;
    private ArrayList<Empleado> planilla;

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

    }

    static public void quitarEmpleado(String nombre){
        System.out.println("Ingrese el nombre del empleado a despedir: ");
        nombre = in.nextLine();


    }
}
