package paquete;

import java.util.Scanner;

/**
 * Menu de opciones para lanzar los 5 ejercicios de la tarea
 */
public class Tarea04 {

    //Para ejecutar los 5 ejercicios desde este programa
    public static void main(String[] args) {
        
        int ejercicio=0;
        System.out.println("1 - Ejercicio 1 Tabla de multiplicar");
        System.out.println("2 - Ejercicio 2 Cinco numero por teclado");
        System.out.println("3 - Ejercicio 3 MCM de dos numeros");
        System.out.println("4 - Ejercicio 4 Juego número oculto");
        System.out.println("5 - Ejercicio 5 Manejo de excpeciones");
        System.out.print("Que ejercicio deseas ejecutar (otra para salir): ");
        Scanner sc = new Scanner(System.in);
        try {
            ejercicio = sc.nextInt();
        } catch (java.util.InputMismatchException e ) {
            sc.nextLine();
        } 
        switch (ejercicio) { 
            case 5:
                System.out.print("\nEjercicio 5 - Control de excepciones\n");
                PROG04_Ejerc5.main(args);
                break;
            case 4:
                System.out.print("\nEjercicio 4 - Juego del número secreto\n");
                PROG04_Ejerc4.main(args);
                break;
            case 3:
                System.out.print("\nEjercicio 3 - Mínimo Común Múltiplo de 2 números\n");
                PROG04_Ejerc3.main(args);
                break;
            case 2:
                System.out.print("\nEjercicio 2 - Analiza 5 numeros: negativos, positivos, primos\n");
                PROG04_Ejerc2.main(args);
                break;
            case 1:
                System.out.print("\nEjercicio 1 - Tablas de multiplicar\n");
                PROG04_Ejerc1.main(args);
                break;
            default:
                System.out.println("Salida...");
        }        
    }
}
