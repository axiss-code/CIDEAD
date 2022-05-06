package Tarea02;

public class PROG02_Ejerc8 {
    
    public static void main(String[] args) {
        
        int alu_prog = 121;
        int alu_eedd = 98;
        int alu_bbdd = 116;
        int alu_total = alu_prog + alu_eedd + alu_bbdd;
        
        //Hay castear para que se tengan en cuenta los decimales
        //No guardaremos el valor de los porcentajes, ya que simplemente nos interesa mostrarlos sin más.
        //Daremos formato con printf
        System.out.println("Matriculacion de alumnos por asignatura.");
        System.out.print("Entornos de Desarrollo: "+alu_eedd+" (");
        System.out.printf("%.1f",(double) alu_eedd*100/alu_total);
        System.out.println("%)");
        System.out.print("Bases de Datos: "+alu_bbdd+" (");
        System.out.printf("%.1f",(double) alu_bbdd*100/alu_total);
        System.out.println("%)");
        System.out.print("Programacion: "+alu_prog+" (");
        System.out.printf("%.1f",(double) alu_prog*100/alu_total);
        System.out.println("%)");
    }
    
}
