package Tarea02;

public class PROG02_Ejerc7 {
    
    //C1 * x - C2 = 0   --> averiguar el valor de x
    //Se debe mostrar el resultado con 4 decimales
    public static void main(String[] args) {
    
        float c1=55.2342f;
        float c2=-14.56f;
        float x = -c2/c1;
        
        //con printf, conseguiremos dar formato al resultado obtenido
        System.out.println("De la ecuación C1 * x - C2 = 0");
        System.out.println("Siendo C1 = "+c1+"\nSiendo C2 = "+c2);
        System.out.printf("El valor de x es igual a = %1.4f",x);
    }
}
