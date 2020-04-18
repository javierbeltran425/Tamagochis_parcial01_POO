package com.RJBM.x00019315;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Empresa empresa = new Empresa("Microsoft");
    static  Scanner in = new Scanner(System.in);
    public static void main(String[] args) {

        boolean continuar = true;
        int opción;
        double sueldo;
        System.out.println("*********************");
        System.out.println(" Sistema de empresa");
        System.out.println("*********************");


    do {
        System.out.print("1. Agregar empleado\n2. Despedir empleado\n 3. Ver lista de empleados\n4. Calcular sueldo\n5. Mostrar totales");
        opción = in.nextInt();
        in.nextLine();

        try {
        switch (opción) {
            case 1:
                anadirEmpleado();
                break;
            case 2:
                quitEmpleado();
                break;
            case 3:
                listaEmpleados();
                break;
            case 4:
                String nombre = null;
                ArrayList<Empleado> a;
                CalculadoraImpuestos b;
                b = new CalculadoraImpuestos();

                System.out.print("Ingrese el nombre de empleado: ");
                nombre = in.nextLine();

                a = empresa.getPlanilla();

                for (Empleado aux : a) {
                    if (aux.getNombre().equals(nombre)) {
                        sueldo = b.calcularPago(aux);
                        System.out.print("Sueldo total: $" + sueldo);
                    }
                }

                break;
            case 5:
                String Nombre;
                ArrayList<Empleado> pl = new ArrayList<>();
                CalculadoraImpuestos impuesto = new CalculadoraImpuestos();

                System.out.print("Ingrese el nombre del emplado: ");
                Nombre = in.nextLine();

                pl = empresa.getPlanilla();

                for (Empleado aux : pl) {
                    if (!pl.isEmpty()) {
                        if (aux.getNombre().equals(Nombre)) {
                            System.out.print(impuesto.mostrarTotales());
                        }
                    }
                }

                break;

            case 6:
                System.out.println("Saliendo...");
                continuar = false;
                break;

            default:
                System.out.print("Opción incorrecta");
        }
        }catch (InputMismatchException mis){
          System.out.print("Missmatch");
        } catch(ArithmeticException ex){
            System.out.print(ex.getMessage());
        }catch(Exception mes) {
            System.out.print(mes.getMessage());
        }

    } while (continuar);

    }

    public static void anadirEmpleado() throws Exception {
        String persona;
        int opción;
        String puesto;
        double salario;
        System.out.println("**********************************");
        System.out.println(" Sistema de registro de empleados");
        System.out.println("**********************************");

        System.out.print("Ingrese el nombre del empleado: ");
        persona = in.nextLine();
        System.out.print("\nIngrese el puesto a desempeñar: " + "\n\t1. Plaza fija\n\t2. Servicio profesional");
        opción = in.nextInt(); in.nextLine();

        switch (opción){
            case 1:
                try {
                    puesto = "Plaza fija";
                    System.out.println("Ingrese la extension del contrato: ");
                    int extension = in.nextInt();
                    in.nextLine();
                    System.out.print("\nIngrese el salario de este empleado: ");
                    salario = in.nextDouble(); in.nextLine();
                    PlazaFija p1 = new PlazaFija(persona, puesto, salario, extension);
                    Empresa.addEmpleado(p1);
                }catch (InputMismatchException mis){
                    in.nextLine();
                    throw new InputMismatchException("Error");
                } catch(Exception e){
                    System.out.print("Error");
                }
                break;
            case 2:
                try {
                    puesto = "Servicio profesional";
                    System.out.println("Ingrese los meses de contrato: ");
                    int mesesContrato = in.nextInt();
                    in.nextLine();
                    System.out.print("\nIngrese el salario de este empleado: ");
                    salario = in.nextDouble();
                    in.nextLine();
                    ServicioProfesional p2 = new ServicioProfesional(persona, puesto, salario, mesesContrato);
                    Empresa.addEmpleado(p2);
                }catch (InputMismatchException mis){
                    in.nextLine();
                    throw new InputMismatchException("Error");
                }catch (Exception e){
                    System.out.print("Error");
                }
                break;
            default: System.out.print("Opción incorrecta");
        }
    }

    public static void listaEmpleados(){
        ArrayList<Empleado> e;
        e = empresa.getPlanilla();

        for (Empleado aux: e) {
            System.out.print("Nombre: " + aux.getNombre() + "\nPuesto: " + aux.getPuesto() + "\nSalario: " + aux.getSalario());
        }
    }

    public static void quitEmpleado() {
        String nombre = null;

        System.out.print("Ingrese el nombre del empleado: ");
        nombre = in.nextLine();

        Empresa.quitEmpleado(nombre);
    }
}