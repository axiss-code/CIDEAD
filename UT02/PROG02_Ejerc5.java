package Tarea02;

import java.util.Scanner;

public class PROG02_Ejerc5 {
    
    // dado un número de segundos, muestre en pantalla cuántos minutos, horas y días contiene.
    
    public static void main(String[] args) {
        
        // introduciremos los segundo por teclado
        Scanner sc = new Scanner(System.in);
        System.out.print("Cuantos segundos deseas calcular: ");
        long segundos = sc.nextLong();
        
        int min=0, hor=0, dia=0;
        long seg=segundos;
        
        // Haremos uso del while, por lo que nos interesa saber lo sig:
        // 1 min = 60 seg
        // 1 hor = 3600 seg
        // 1 dia = 86400 seg
        
        while (seg>59) {  //terminará el bucle en cuanto la varibale seg sea menor a 60.
            if (seg>86400) {
                dia++;
                seg -= 86400;
            } else if (seg>3600) {
                hor++;
                seg -= 3600;
            } else {
                min++;
                seg -= 60;
            }
        }
       
        System.out.println(segundos+" segundos equivalen a:");
        System.out.println(dia + " dias, \n" + hor + " horas, \n" + min + " minutos, \n" + seg + " segundos.");
        sc.close();
    }
 }

