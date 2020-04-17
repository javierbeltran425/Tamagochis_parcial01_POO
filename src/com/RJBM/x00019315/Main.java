package com.RJBM.x00019315;

public class Main {

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
        
    }
}