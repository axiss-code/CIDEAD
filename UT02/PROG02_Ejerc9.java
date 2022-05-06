package Tarea02;

import java.util.Scanner;

public class PROG02_Ejerc9 {
    
    //Diseñar un programa que dado un año indique si es bisiesto o no. Se considerará año bisiesto aquel,
    //que sea divisible por 4 pero no por 100 salvo que sea divisible por 400: 1900 y 2100 no bisiestos, 1904 sí y 2000 también.
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el año a comprobar: ");
        int year = sc.nextInt();
        
        if (year %4 == 0 && year %100 != 0 || year %400 == 0){
            System.out.println("Es bisiesto.");
        } else {
            System.out.println("No es bisiesto.");
        }
       sc.close();
    }
    
}
