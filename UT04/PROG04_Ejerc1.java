package paquete;

import java.util.Scanner;
/**
 * Implementar un programa que muestre la tabla de multiplicar de un número leido desde teclado utilizando al menos
 * tres bucles diferentes. El número leído desde teclado debe ser menor que 30. En caso contrario se mostrará un mensaje
 * por pantalla y el programa finalizará.
 */
public class PROG04_Ejerc1 {
    
    public static void main(String[] args) {
        
        System.out.print("Introduce un numero entero entre 1 y 30: ");
        Scanner sc = new Scanner(System.in); //creamos un objeto de la clase Scanner
        int num = sc.nextInt(); //que nos almacenará el numero introducido por teclado. Si no es entero, dará error.
        
        /**
         * Con el if daremos 2 respuestas posibles. Si fera de rango, el programa muestra un mensaje de terminado
         * Si el numero está comprendido en el rango, mostrará la tabla de multiplicar del 0 al 10 con 3 bucles distintos
         */
        if (num < 1 || num > 30) {
            System.out.println("Número introducido fuera de rango."
                    + "\nFin del programa.");  
        } else {
            //Primero se muestra utilizando el bucle for
            System.out.println("Tabla de multiplicar del nº "+num);
            System.out.println("Utilizando un bucle for:");
            for (int i=0; i<11; i++) System.out.println(i+"x"+num+"="+(i*num));
            
            //Seguidamente se obtiene lo mismo pero con un while
            System.out.println("\nUtilizando un bucle while:");
            int j=0; //vamos a usar un contador para que se repita el bucle, mientras sea inferior a 11.
            while (j<11){ 
                System.out.println(j+"x"+num+"="+(j*num));
                j++; //incremento en 1 del contador
            }
            
            //Finalmente con un for-each
            //Para el for-each, vamos a almacenar en un array los número a multiplicar
            System.out.println("\nUtilizando un bucle for-each:");
            int [] tabla = {0,1,2,3,4,5,6,7,8,9,10}; //array
            for (int k:tabla) { //blucle que recorre el array utilizando la variable k
                System.out.println(k+"x"+num+"="+(k*num));
            }
        }
        //Cerramos el objeto de scanner para que no siga "oyendo" las entradas por teclado. 
        sc.close();
    }
}
