package paquete;

import java.util.Scanner;

/**
 * Un número es primo si solo tiene dos divisores: el 1 y el propio número. Implementa un programa Java 
 * que pida por teclado 5 números. Para cada uno de ellos:
 * - Comprueba si es negativo. En caso afirmativo, muestra el mensaje por pantalla "El número es negativo".
 * - Si es positivo, deberá mostrar por pantalla si es primo o no.
 * - Procesados los 5 números, el programa finaliza.
 */
public class PROG04_Ejerc2 {
    
    public static void main(String[] args) {
        
        int contador=1; //lo inicializamos a 1, ya que al ser un do-while, al menos se ejecutara una vez.
        do {
            System.out.print("(Intento "+contador+"/5) Introduce el número a comprobar: ");
            Scanner sc = new Scanner(System.in); //creamos un objeto de la clase Scanner
            int num = sc.nextInt(); //que nos almacenará el numero introducido por teclado. Si no es entero, dará error.
            
            if (num < 0) { //comprueba primero si el número es negativo
            System.out.println("El número "+num+" es negativo.");
            } else {
                //en caso contrario, analizará si es o no primo pasando el valor introducido por teclado a la función esPrimo
                if (esPrimo(num)){
                    System.out.println("El número "+num+" es primo."); 
                } else {
                    System.out.println("El número "+num+" no es primo.");
                }
            }			
            contador++;
        } while (contador < 6);       
    }
    
    /**
     * El método esPrimo, analizará el valor entero pasado desde el metodo main y devolverá
     * @return true si es primo o false en caso contrario.
     */
    static boolean esPrimo (int x) {
        
        /**
         * el 0 y el 1 no son considerados numeros primos
         * el rango de valores a considerar será el comprendido entre: 2....x-1
         */
        boolean esPrimo = (x == 0 || x == 1) ? (esPrimo=false) : (esPrimo=true);
        int rango = 2;
        
        /**
         * mientras haya números que comprobar en el "rango" y la condicion esPrimo no haya cambiado a false
         * se continará comprobando que el resto de x no sea 0.
         * en cuanto sea 0, significará que x es divisible por ese valor dentro del rango, por tanto no sera primo
         */ 
        while (rango <= x-1 && esPrimo == true) {
            if (x % rango == 0) {
                    esPrimo = false;
            }
            rango++;
        }
        return esPrimo;
    }
}
