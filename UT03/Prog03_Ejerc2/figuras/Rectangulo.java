/*rea un proyecto Java denominado Prog03_Ejerc2.
Dentro del proyecto, crea un paquete denominado com.prog03.figuras.
Dentro de dicho paquete, crea una clase denominada Rectangulo 
*/
package com.prog03.figuras;

public class Rectangulo {
    
    //Declare atributos para la base y la altura de un rectángulo.
    private float base, altura; 
    
    //Declare un constructor vacío que inicialice los atributos a 0.
    public Rectangulo() {
    }
    
    //Declara un constructor que inicialice base y altura.
    public Rectangulo(float base, float altura) {
        this.base = base;
        this.altura = altura;
    }

    //Métodos para actualizar y obtener el valor de cada atributo.
    public float getBase() {
        return base;
    }

    public void setBase(float base) {
        this.base = base;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }
    
    public float getArea() {
        float area = this.base*this.altura;
        return area;
    }
    
    public String toString() {
        String cad;
        cad = "Cadena que contiene su área (" + getArea() + ") y su altura (" + altura + ").";
        return cad;
    }
    
    public boolean isCuadrado(){
        return (this.base==this.altura);
    }
   
}
