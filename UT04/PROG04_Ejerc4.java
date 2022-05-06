package paquete;

import java.util.Scanner;

/**
 * Deseamos implementar un juego en Java que permita al usuario adivinar un número oculto (que será aleatorio). 
 * El funcionamiento será el siguiente:
 * El programa mostrará un pequeño menú en pantalla con las siguientes opciones (1. Configurar, 2. Jugar, 3. Salir).
 * - Si el usuario selecciona la primera opción, se le solicitará por teclado el número de intentos permitidos (numInt) y el número
 *   máximo (numMax) generado.
 * - Si el usuario selecciona la opción 2, el programa generará un número aleatorio entre 0 y numMax que será el número a adivinar
 *   (numOculto). A partir de este momento, se le solicitarán al usuario números hasta adivinar el número oculto.
 *      · Si el usuario adivina el número, se mostrará un mensaje "Has ganado!. Has necesitado X intentos".
 *      · Si se consume el número de intentos sin adivinar el número, se mostrará el mensaje "Perdiste!. Intentos consumidos".
 *      · En cada intento, si el usuario no adivina el número se le proporcionará una pista, por ejemplo, "El número oculto es menor".
 *      · En ambos casos, la siguiente acción será mostrar el menú.
 *      · Si el usuario selecciona Jugar sin configurar previamente el número de intentos y el número máximo generado, se tomarán
 *        como valores por defecto: numInt=5 y numMax=10.
 * - Si el usuario pulsa la opción 3, el programa finaliza.
 * Para generar un número aleatorio en java puedes utilizar el siguiente código:
 * int numOculto = (int)Math.floor(Math.random()*20+1); //genera un número aleatorio entre 0 y 20, ambos incluidos.
 *
 */
public class PROG04_Ejerc4 {
    
    static int numInt = 5;  //nro de intentos por defecto
    static int numMax = 10; //nro máximo generado por defecto
    
    public static void main(String[] args) {
        
        boolean exit = false; //bandera que utilizaremos para salir del menu y finalizar
        
        System.out.println("El número oculto!");
        //con el do-while, nos aseguramos de que se muestre el menú al menos una vez.
        do {
            mostrarMenu(); //invocamos el menu en pantalla
            Scanner teclado = new Scanner(System.in);
            int opcion = teclado.nextInt();
            
            //para cualquier numero entero introducido distinto a 1-2-3, repetirá la pregunta
            switch (opcion) { 
            case 3:
                System.out.println("Fin del juego.");
                exit=true;
                break; //sin el break continuarían ejecutandose los case posteriores hasta el final
            case 2:
                jugar(numInt,numMax); //invocamos el metodo jugar, pasándole intentos y nro maximo
                break; 
            case 1:
                configurar();
                break;
            default:
                System.out.println("Opción no válida.\n");
            }
        } while (exit != true); //el bucle se interrumpirá cuando se seleccione el 3 -> que cambia el valor a true.
    }
    
    /**
     * Método de tipo void que nos mostrará el menu siempre que lo invoquemos
     */
    static void mostrarMenu () {
        System.out.print("1. Configurar"
                + "\n2. Jugar"
                + "\n3. Salir"
                + "\n\nElige una opcion: ");
    }
    
    /**
     * Método para establecer el numero de intentos y el valor maximo a generar.
     */
    static void configurar () {
        System.out.println("-- Configuración --");
        Scanner teclado = new Scanner(System.in);
        System.out.print("Elige el número de intentos permitidos: ");
        numInt = teclado.nextInt();
        System.out.print("Establece el número máximo a adivinar: ");
        numMax = teclado.nextInt();
        System.out.println("\nEl número secreto estará entre 0 y "+numMax+". Tendrás un máximo de "+numInt+" intentos.\n");
    }
    
    /**
     * Método que compara los intentos con el número aleatorio generado
     */
    static void jugar (int numInt, int numMax) {
        System.out.println("\nComienza el juego! Adivina el número oculto entre 0 y "+numMax);
        Scanner teclado = new Scanner(System.in);
        
        int numOculto = (int)Math.floor(Math.random()*numMax+1); //genera el numero aleatorio secreto, entre 0 y numMax
        boolean acierto=false;
        int contador=1; //inicializamos en 1 ya que el do-while nos asegura que al menos se producira una vez
        do {
            System.out.print("Intento "+contador+" de "+numInt+": ");
            int intento = teclado.nextInt();
            if (intento == numOculto) {
                //si el numero introducido es igual al generado
                //cambia el valor de "acierto" y sale del bucle.
                acierto = true; 
            } else if (intento < numOculto) {
                //si no, dará la pista correspondiente y aumentará el contador en 1
                System.out.println("Incorrecto. El número oculto es mayor.");
                contador++;
            } else {
                System.out.println("Incorrecto. El número oculto es menor.");
                contador++;
            }
        } while (contador <= numInt && acierto == false); // se repetira mientras el contador sea <= numero de intentos y no se haya acertado
        
        System.out.print(acierto ? "\nHas ganado! Has necesitado "+contador+" intentos" : "\nPerdiste! Intentos consumidos. El número era el "+numOculto);
        System.out.println(".\n");
        //regresa al switch
    }
}
