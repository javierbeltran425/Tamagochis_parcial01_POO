package com.RJBM.x00019315;

import java.util.ArrayList;
import java.util.Scanner;

public class Empresa {
    static Scanner in = new Scanner(System.in);
    private static String nombre;
    private static ArrayList<Empleado> planilla = new ArrayList<>();

    public Empresa(String nombre) {
        this.nombre = nombre;
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

    static public void quitEmpleado(String nombre)  {

        for (Empleado aux: planilla) {
            if(aux.getNombre().equals(nombre)){
                planilla.remove(aux);
                System.out.print("Empleado despedido");
                break;
            }else{
                System.out.print("Empleado no encontrado");
            }
        }
    }


}
