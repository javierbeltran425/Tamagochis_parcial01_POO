package com.RJBM.x00019315;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static  Scanner in = new Scanner(System.in);
    public static void main(String[] args) {

        String nombre = null;
        boolean continuar = true;
        int opción;
        double sueldo;
        System.out.println("*********************");
        System.out.println(" Sistema de empresa");
        System.out.println("*********************");

        do {
            System.out.print("1. Agregar empleado\n2. Despedir empleado\n 3. Ver lista de empleados\n4. Calcular sueldo\n5. Mostrar totales");
            opción = in.nextInt(); in.nextLine();

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
                    ArrayList<Empleado> a;
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
                    String nombre1;
                    System.out.println("Ingrese el nombre del empleado: ");
                    nombre1 = in.nextLine();
                    String nombreFinal = nombre1;

                    ArrayList<Empresa> c = null;
                    for (Empresa aux: c){
                        if (nombreFinal.equals(nombre))
                            System.out.println(c.toString());
                    }
                    break;

                case 6:
                    System.out.println("Saliendo...");
                    continuar = false;
                    break;

                default: System.out.print("Opción incorrecta");
            }

        }while(continuar);
    }

    public static void addEmpleado() throws NullPointerException{
        String persona;
        int opción;
        String puesto = null;
        double salario = 0;
        System.out.println("**********************************");
        System.out.println(" Sistema de registro de empleados");
        System.out.println("**********************************");

        System.out.print("Ingrese el nombre del empleado: ");
        persona = in.nextLine();
        System.out.print("\nIngrese el puesto a desempeñar: " + "\n\t1. Plaza fija\n\t2. Servicio profesional");
        opción = in.nextInt(); in.nextLine();

        switch (opción){
            case 1:
                puesto = "Plaza fija";
                System.out.println("Ingrese la extension del contrato: ");
                int extension = in.nextInt(); in.nextLine();
                System.out.print("\nIngrese el salario de este empleado: ");
                salario = in.nextDouble(); in.nextLine();
                PlazaFija p1 = new PlazaFija(persona, puesto, salario, extension);

                break;
            case 2:
                puesto = "Servicio profesional";
                System.out.println("Ingrese los meses de contrato: ");
                int mesesContrato = in.nextInt(); in.nextLine();
                System.out.print("\nIngrese el salario de este empleado: ");
                salario = in.nextDouble(); in.nextLine();
                ServicioProfesional p2 = new ServicioProfesional(persona, puesto, salario, mesesContrato);
                break;
            default: System.out.print("Opción incorrecta");
        }
        Empresa list = new Empresa(persona);
        list.getPlanilla().add(new Empleado(persona);


    }

    public static void listaEmpleados(){
        Empresa e = null;
        assert false;
        System.out.print(e.getPlanilla());
    }

    public static void quitEmpleado(String nombre){
        Empresa d = null;
        try {
            if(nombre == null)
                throw new NotExistingEmployee("No existe tal empleado.");

            d.quitEmpleado(nombre);
        }
        catch (NotExistingEmployee ex){
            System.out.println(ex.getMessage());
        }
    }
}