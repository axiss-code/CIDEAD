package paquete;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
/**
 * Cuando dividimos un número entre 0 se genera un valor indeterminado. En cualquier lenguaje de programación este tipo de
 * operaciones genera un error de ejecución que debe ser controlado desde el código para evitar malas experiencias al usuario. En Java,
 * cuando se produce esta operación se genera la excepción ArithmeticException. Queremos implementar un programa Java que calcule la división
 * de dos números solicitados por teclado (dividendo y divisor). El programa solicitará números indefinidamente hasta que los dos números
 * solicitados sean -1. Se debe controlar mediante excepciones que el divisor no sea 0. En caso de serlo, se mostrará un mensaje por
 * pantalla. También habrá que mostrar por pantalla el número de divisiones calculadas. Utiliza número enteros para las variables
 */
public class PROG04_Ejerc5 {
    
    public static void main(String[] args) {
        
        boolean exit=false;
        int contador=0;
        int intentos=0;
        System.out.println("-- Probando try catch finally con BufferedReader --");
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        do{
            try{
                System.out.print("Introduzce el dividendo: ");
                int num1 = Integer.parseInt (teclado.readLine());
                System.out.print("Introduzce el divisor: ");
                int num2 = Integer.parseInt (teclado.readLine());
                
                if (num1 == -1 && num2 == -1) {
                    exit=true;
                } else {
                    int division = num1/num2;
                    System.out.println("El resultado de la division es "+division+"\n");
                    contador++;
                }
            } catch (IOException e){ //es necesaria capturarla con BufferedReader
                System.out.println("Error al leer del teclado."); 
            } catch (ArithmeticException e) { //captura los errores al dividir por cero
                System.out.println("No se puede dividir entre cero.\n");  
            } catch (NumberFormatException e){ //captura los errores cuando lo que se introduce no es un int, por ej una letra
                System.out.println("Debe introducir un número entero o -1 para salir\n");
            } finally{
                intentos++;
            }
        } while (!exit);
        System.out.println("\nNúmero de divisiones calculadas: " + contador+" en " + intentos +" intentos\n");
        
        
        /**
         * Ahora haremos lo mismo pero utilizando el método Scanner
         */
        exit=false;
        contador=0;
        System.out.println("-- Probando try catch con Scanner --");
        Scanner sc = new Scanner(System.in);
        do {
            try {
                 System.out.print("Introduzce el dividendo: ");
                int num1 = sc.nextInt();
                System.out.print("Introduzce el divisor: ");
                int num2 = sc.nextInt();

                if (num1 == -1 && num2 == -1) {
                    exit=true;
                } else {
                    int division = num1/num2;
                    System.out.println("El resultado de la division es "+division+"\n");
                    contador++;
                }
            } catch (ArithmeticException e) { //captura los errores al dividir por cero
                System.out.println("No se puede dividir entre cero.\n");
            } catch (java.util.InputMismatchException e ) { //captura los errores cuando lo que se introduce no es un int, por ej una letra
                System.out.println("Debe introducir un número entero o -1 para salir\n");
                sc.nextLine();
            } 
            
        } while (!exit);
        System.out.println("\nNúmero de divisiones calculadas: " + contador);
    }
}
