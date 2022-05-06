package Tarea02;

public class PROG02_Ejerc1 {
    
    //Declara e inicializa una variable para almacenar cada uno de los siguientes valores.
    //Trata de utilizar el tipo de datos que mas se ajuste a los datos. Justifica tu elección.

    public static void main(String[] args) {
        
        /* final -> porque es una constante
        MAX -> en mayúscula por ser una buena práctica
        tipo short -> porque es 5000 */
        final short MAX = 5000;
        System.out.print("Valor máximo es: "+MAX);
        
        
        // como se requieren solo 2 valores, uno se identificara con true y el otro con false
        boolean carnet_empleado = true; 
        System.out.print("\nEmpleado tiene carnet = "+carnet_empleado);
        
        
        byte mes = 2;  // byte -> es suficiente porque los meses no superan nunca el 12 [-128 al 127]
        String mes_cadena = "febrero"; // String -> al ser un valor alfanumérico
        System.out.print("\nMes en número = "+mes);
        System.out.print("\nMes en texto = "+mes_cadena);
        
        
        String nombre = "Juan"; // String -> al ser un valor alfanumérico
        String apellido = "Sanchez"; // String -> al ser un valor alfanumérico
        System.out.print("\nNombre y Apellido es "+nombre+" "+apellido );
        
        
        // como se requieren solo un caracter, usaremos char.
        char sexo = 'V'; 
        System.out.print("\nSexo = "+sexo);
        
        
        // long -> por si fuese superior a 2147483647 (limite de int)
        long milisengundos = 1000000000000L;
        System.out.print("\nMilisegundos desde 1970: "+milisengundos);
        
        
        // double -> al necesitarse valores con decimales
        float saldo = 4520.52f;
        System.out.print("\nSaldo de la cuenta bancaria: "+saldo);
        
        
        // double -> al necesitarse valores muy grandes con decimales
        double distancia = 590000000;
        System.out.print("\nDistancia de la Tierra a Jupiter: "+distancia);
    }
    
}
