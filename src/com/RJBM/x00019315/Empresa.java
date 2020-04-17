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


        planilla.add(persona);
    }

    static public void quitEmpleado(String nombre) throws NotExistingEmployee {
        System.out.println("Ingrese el nombre del empleado a despedir: ");
        nombre = in.nextLine();

        for (Empleado aux: planilla) {
            if(aux.getNombre().equals(nombre)){
                planilla.remove(aux);
                System.out.print("El empleado a sido despedido");
            }

            else
                throw new NotExistingEmployee("No existe ese empleado.");
        }
    }
}
