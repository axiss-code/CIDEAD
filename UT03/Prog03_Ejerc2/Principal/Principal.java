/*Crea otro paquete con el nombre com.prog03.Principal.
Dentro de dicho paquete crea una clase denominada principal que contenga el método main.
En el método main, instancia al menos dos objetos de la clase Rectangulo
y comprueba su funcionamiento.
*/
package com.prog03.Principal;

import com.prog03.figuras.Rectangulo;

public class Principal {
    
    public static void main(String[] args) {
        
        Rectangulo r1 = new Rectangulo();
        r1.setAltura(5.5F);
        r1.setBase(7.85F);
        
        System.out.println("El área del rectángulo r1 es: "+ r1.getArea());
        System.out.println(r1.toString());
        
        if (r1.isCuadrado()) {
            System.out.println("Es cuadrado");
        } else {
            System.out.println("No es cuadrado");
        }
        
        Rectangulo r2 = new Rectangulo(2F, 2F);
        
        System.out.println("\nEl área del rectángulo r2 es: "+ r2.getArea());
        System.out.println("Altura de r2 es: "+ r2.getAltura());
        System.out.println("Base de r2 es: "+ r2.getBase());
        System.out.println(r2.toString());
        
        if (r2.isCuadrado()) {
            System.out.println("r2 es cuadrado");
        } else {
            System.out.println("r2 no es cuadrado");
        }
        
        
        r2.setAltura(8.88F);
        
        System.out.println("\nNueva altura de r2 es: "+ r2.getAltura());
        
        if (r2.isCuadrado()) {
            System.out.println("r2 es cuadrado");
        } else {
            System.out.println("r2 no es cuadrado");
        }
    }
}
