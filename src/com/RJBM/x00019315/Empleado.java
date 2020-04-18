package com.RJBM.x00019315;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Empleado {
    static Scanner in = new Scanner(System.in);
    protected String nombre;
    protected String puesto;
    static protected List <Documento> documentos;
    protected double salario;

    //Contructor
    public Empleado(String nombre, String puesto, double salario) {

        try{
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = salario;
        documentos = new ArrayList<>();

    }catch (ArithmeticException a){
            System.out.print("HOLA...");
        }
    catch(Exception e)
    {
        System.out.print("HOLA...");
    }
    }

    public String getNombre() {
        return nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public List<Documento> getDocumentos() {
        return documentos;
    }

    public static void addDocumento(Documento d){
        documentos.add(d);
    }

    public static void removeDocumento(String nombreF) throws NotExistingDocuments {

            System.out.println("Ingrese el nombre del documento a eliminar: ");
            nombreF = in.nextLine();
            String nombreFinal = nombreF;
            for(Documento f : documentos){
                if(f.getNombre() == nombreF)
                    documentos.removeIf(obj -> obj.getNombre() == nombreFinal);

                else
                throw new NotExistingDocuments("No existe un documento con ese nombre.");
            }


    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}