/* vamos a probar su funcionalidad desde otra clase, denominada Principal,
que contendrá el método main. Esta clase la debes crear en el mismo paquete que la clase Fecha.
*/

package Tarea03;

public class Principal {

    public static void main(String[] args) {
        
        //Instancia un objeto de la clase Fecha denominado objFecha1 con el primer constructor.
        Fecha objFecha1 = new Fecha(enumMes.DICIEMBRE);
        
        //Actualiza los atributos dia y año para dicho objeto.
        objFecha1.setDia(14);
        objFecha1.setAnio(2021);
        
        //Muestra la fecha por pantalla en formato largo.
        System.out.println("Primera fecha, inicializada con el primer constructor:");
        System.out.println("La fecha es: " + objFecha1);
        //MMuestra un mensaje por pantalla indicando si la fecha es verano.
        
        if (objFecha1.isSummer()) {
            System.out.println("Es verano!");
        } else {
            System.out.println("No es verano");
        }
        
        //Instancia otro objeto de la clase Fecha denomiando objFecha2 con el segundo constructor.
        Fecha objFecha2 = new Fecha(1, enumMes.AGOSTO, 1999);
        
        //Muestra el año de esta fecha por pantalla.
        System.out.println("\nSegunda fecha, inicializada con el segundo constructor:");
        
        //Muestra la fecha en formato largo por pantalla.
        System.out.println("La fecha 2 contiene el año "+objFecha2.getAnio());
        
        //Muestra un mensaje por pantalla indicando si la fecha es verano o no.
        System.out.println("La fecha es: " + objFecha2);
        
        //Muestra un mensaje por pantalla indicando si la fecha es verano o no.
        if (objFecha2.isSummer()) {
            System.out.println("Es verano!");
        } else {
            System.out.println("No es verano");
        }
    }
    
}
