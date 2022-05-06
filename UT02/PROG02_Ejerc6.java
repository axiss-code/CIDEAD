package Tarea02;

public class PROG02_Ejerc6 {
    
    /*Cree un tipo enumerado para las siguientes razas de perro: Mastín, Terrier, Bulldog, Pekines, Caniche y Galgo.
      -Crea una variable denominada var1 del tipo enumerador. Asígnale un valor.
      -Crea una variable denominada var2 del tipo enumerador. Asígnale un valor.
      -Muestra por pantalla el valor obtenido de comparar ambas variables.
      -Investiga sobre la posibilidad averiguar la posición que ocupa un determinado valor en el enumerado
      así como mostrar la cantidad de valores que contiene. Si lo consigues, muestra la posición
      de las dos variables en el tipo enumerado. */
     
    
    //Los tipos enumerados son parecidos a las clases. Sirven para definir grupos
    //de constantes como valores posibles de una variable.
    //Si queremos usar un tipo enumerado, lo podemos implementar en un archivo nuevo
    //dentro del paquete donde está el programa principal, como si fuera una clase.
    //Los items en mayúsculas, por buenas prácticas.
    public enum RazasPerro {
        MASTIN,
        TERRIER,
        BULLDOG,
        PEKINES,
        CANICHE,
        GALGO
    }
    
    public static void main(String[] args) {
        
        RazasPerro var1 = RazasPerro.MASTIN;
        RazasPerro var2 = RazasPerro.BULLDOG;
        
        //Muestra por pantalla el valor obtenido de comparar ambas variables.
        System.out.print("var1 = "+var1+"\nvar2 = "+var2+"\n¿ var1 es igual a var2 ? : ");
        System.out.println(var1==var2 ? "Son iguales." : "No son iguales.");
        
        //averiguar la posición que ocupa un determinado valor en el enumerado así como mostrar la cantidad de valores que contiene.
        System.out.println("Cantidad de valores : "+RazasPerro.values().length);
        
        //muestra la posición de las dos variables en el tipo enumerado.
        System.out.println(var1+" posicion : "+var1.ordinal());
        System.out.println(var2+" posicion : "+var2.ordinal());   
        
    }
} 

