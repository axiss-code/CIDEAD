package Tarea02;

import java.util.Scanner;

public class PROG02_Ejerc4 {
    
    // dada la edad de una persona, muestre un mensaje indicando si es mayor de edad.
    // NO se puede utilizar el operador condicional if.
    
    public static void main(String[] args) {
        
        // pidiendo la edad introducida por teclado
        Scanner sc = new Scanner(System.in);
        System.out.print("Edad del primero: ");
        int edad1= sc.nextInt();
        
        // operador ternario en reemplazo del if
        System.out.println(edad1 > 17 ? "Es mayor" : "Es menor"); 
        
        // dadas las edades como dato
        int edad2=15;
        int edad3=50;
        String esMayor;
        
        // operador ternario en reemplazo del if
        esMayor = (edad2 > 18) ? (esMayor="es mayor") : (esMayor="es menor");
        System.out.println("El segundo "+esMayor+" de edad.");
        
        // operador ternario en reemplazo del if
        esMayor = (edad3 > 18) ? (esMayor="es mayor") : (esMayor="es menor");
        System.out.println("El tercero "+esMayor+" de edad.");
        
        sc.close();
    }
}
