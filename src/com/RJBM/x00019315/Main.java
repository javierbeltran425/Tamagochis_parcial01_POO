package com.RJBM.x00019315;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Empresa empresa = new Empresa("Microsoft");
    static  Scanner in = new Scanner(System.in);
    public static void main(String[] args) {

        boolean continuar = true;
        int opción;
        double sueldo;


    do {
        System.out.println();
        System.out.println("*********************");
        System.out.println(" Sistema de empresa");
        System.out.println("*********************");

        System.out.print("1. Agregar empleado\n2. Despedir empleado\n3. Ver lista de empleados\n4. Calcular sueldo" +
                "\n5. Mostrar totales\n6. Salir");
        System.out.println();
        System.out.print("Ingrese su opcion: ");
        opción = in.nextInt();
        in.nextLine();

        try {
            switch (opción) {
                case 1:
                    anadirEmpleado();
                    System.out.println();
                    break;
                case 2:
                    quitEmpleado();
                    System.out.println();
                    break;
                case 3:
                    listaEmpleados();
                    System.out.println();
                    break;
                case 4:
                    String nombre;
                    ArrayList<Empleado> a;
                    CalculadoraImpuestos b;
                    b = new CalculadoraImpuestos();

                    System.out.print("Ingrese el nombre de empleado: ");
                    nombre = in.nextLine();

                    a = empresa.getPlanilla();

                    for (Empleado aux : a) {
                        if (aux.getNombre().equalsIgnoreCase(nombre)) {
                            sueldo = b.calcularPago(aux);
                            System.out.print("Sueldo total: $" + sueldo);
                        }
                    }

                    System.out.println();

                    break;
                case 5:
                    CalculadoraImpuestos impuesto = new CalculadoraImpuestos();

                    empresa.getPlanilla();
                    System.out.print(impuesto.mostrarTotales());

                    System.out.println();
                    break;

                case 6:
                    System.out.println("Saliendo...");
                    continuar = false;

                    System.out.println();
                    break;

                default:
                    System.out.print("Opción incorrecta");
            }
        } catch(ExcepciónEmpleado ex){
            System.out.println(ex.getMessage());
        }catch (InputMismatchException mis){
          System.out.print(mis.getMessage());
        } catch(ArithmeticException ex){
            System.out.print(ex.getMessage());
        }catch(Exception mes) {
            System.out.print(mes.getMessage());
        }

    } while (continuar);

    }

    public static void anadirEmpleado() throws Exception {
        String persona;
        String tipoDocumento;
        String numeroDocumento;
        int opción;
        String puesto;
        double salario;
        System.out.println();
        System.out.println("**********************************");
        System.out.println(" Sistema de registro de empleados");
        System.out.println("**********************************");

        System.out.print("Ingrese el nombre del empleado: ");
        persona = in.nextLine();
        System.out.print("\nIngrese el puesto a desempeñar: " + "\n\t1. Plaza fija\n\t2. Servicio profesional");
        System.out.println();
        System.out.print("Opcion: ");
        opción = in.nextInt(); in.nextLine();

        switch (opción){
            case 1:
                try {
                    puesto = "Plaza fija";
                    System.out.print("Ingrese la extension: ");
                    int extension = in.nextInt();
                    System.out.print("\nIngrese el salario de este empleado: ");
                    salario = in.nextDouble(); in.nextLine();
                    System.out.print("Ingrese tipo de documento: ");
                    tipoDocumento = in.nextLine();
                    System.out.print("Número del documento: ");
                    numeroDocumento = in.nextLine();
                    Documento doc = new Documento(tipoDocumento, numeroDocumento);
                    PlazaFija p1 = new PlazaFija(persona, puesto, salario, extension);
                    Empresa.addEmpleado(p1);
                    Empleado.addDocumento(doc);
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
                    System.out.print("Ingrese los meses de contrato: ");
                    int mesesContrato = in.nextInt();
                    System.out.print("\nIngrese el salario de este empleado: ");
                    salario = in.nextDouble(); in.nextLine();
                    System.out.print("Ingrese tipo de documento: ");
                    tipoDocumento = in.nextLine();
                    System.out.print("Número del documento: ");
                    numeroDocumento = in.nextLine();
                    Documento doc2 = new Documento(tipoDocumento, numeroDocumento);
                    ServicioProfesional p2 = new ServicioProfesional(persona, puesto, salario, mesesContrato);
                    Empresa.addEmpleado(p2);
                    Empleado.addDocumento(doc2);
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

    public static void listaEmpleados() {
        ArrayList<Empleado> e;
        e = empresa.getPlanilla();
        System.out.println();

        if (!e.isEmpty()) {
            for (Empleado aux : e) {
                System.out.println();
                System.out.println("*****");
                System.out.print("Nombre: " + aux.getNombre() + "\nPuesto: " + aux.getPuesto() + "\nSalario: "
                        + aux.getSalario());
             System.out.println();
            }
        } else
            System.out.println("La lista está vacia.");
    }

    public static void quitEmpleado() throws ExcepciónEmpleado, NotExistingDocuments {
        String nombre;

        System.out.print("Ingrese el nombre del empleado: ");
        nombre = in.nextLine();

        Empresa.quitEmpleado(nombre);

        }
    }
