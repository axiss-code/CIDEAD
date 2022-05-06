package paquete;

import java.util.Scanner;

/**
 * El Mínimo Común Múltiplo (MCM) de un conjunto de dos números es el número positivo más pequeño que es múltiplo de los
 * dos números. Es posible calcular el MCM de tres o más números. Por ejemplo, el MCM (2,3) es 6. El 6 es el múltiplo mas pequeño de 2 y
 * de 3. Implementa un programa Java que pida dos números por teclado, compruebe que son positivos y calcule su MCM. En caso de no ser
 * ambos números positivos, el programa mostrará un mensaje por pantalla y finalizará.
 */

/** Análisis previo:
 * El MCM lo podremos obtner de dos maneras diferentes:
 * Una es descomponiendo los números en factores primos como primer paso, lo cual descartaremos por ser más complicado
 * La otra es atendiendo a la fórmula a * b / MCD(a,b), siendo MCD el máximo comun divisor. Es la fórmula que usaremos.
*/
public class PROG04_Ejerc3 {
    
    public static void main(String[] args) {
        
        System.out.println("Se obtendrá el Mínimo Común Múltiplo de dos números positivos.");
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Introduce el primer número: ");
        int a = sc.nextInt();
        System.out.print("Introduce el segundo número: ");
        int b = sc.nextInt();
        System.out.println();
        
        if (a <=0 || b <=0) {
            System.out.println("Ambos números deben ser positivos. Fin del programa.");
        } else {
            int mcm = a * b / maximoComunDivisor (a,b); //Teniendo el MCD, la formula a * b / MCD(a,b) arrojará el MCM
            System.out.println("MCM de "+a+" y "+b+" es: " + mcm);
        }
        sc.close();
    }
 
    /**
     * Lo primero será encontrar el Máximo Común Divisor, para utilizar la formula planteada
     * @return devuelve el MCD de tipo int
     */
    static int maximoComunDivisor(int a, int b) {
        int mcd = 0;
        int indice = Math.min(a, b); //igualmos a indice al menor de los 2 numeros
        while (mcd == 0) {
            if (a % indice == 0 && b % indice == 0) {
                mcd=indice; //saldrá del bucle si haya un valor que al divir ambos numeros, el resto sea cero.
            } else {
                indice--; //cuando indice se iguale a 1, la condición siempre se cumplirá y terminará el bucle.
            }
        }
        //nos devolverá el MCD como un valor de tipo int
        return mcd; 
     }
}
