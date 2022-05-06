package Cuentas;

import Principal.Imprimible;
import java.io.Serializable;

public class Persona implements Imprimible, Serializable {
    
    private String nombre;
    private String apellidos;
    private String dni;
    
    /**
    * Método constructor de Persona
     * @param nombre
     * @param apellidos
     * @param dni
    */
    public Persona(String nombre, String apellidos, String dni) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
    }
    
    /**
    * Métodos Setter y Getter
    */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
    
    /**
     * Método de la interfaz Imprimible, que devolverá la información como una cadena de caracteres.
     * 
     * @return String con los datos de los atributos de clase.
     */
    @Override
    public String devolverInfoString() {
        return ("Nombre: "+getNombre()+"\nApellidos: "+getApellidos()+"\nDNI: "+getDni());
    }
    
    public String devuelveNombreApellido() {
        return (getNombre()+" "+getApellidos());
    }
}
