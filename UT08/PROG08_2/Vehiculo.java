/**
 * Tarea 05 - Clase Vehiculo
 * 
 * La clase debe disponer de los siguientes métodos:
 * - Constructor o constructores
 * - Métodos get y set para acceder a sus propiedades.
 * - Método get_Anios(): Retorna un entero con el número de años del vehículo.
 * 
 * Restricciones de la clase:
 * - No se debe solicitar datos por teclado ni escribir datos en pantalla.
 * - No se hacen validaciones de datos.
 * 
 * Otras consideraciones:
 * - Los métodos públicos de interfaz necesarios sean accesibles y funcionen correctamente
 */

//No se ha modificado la clase Vehiculo, se ha reutilizado de la Tarea5
package PROG08_2;

import java.time.LocalDate;

public class Vehiculo implements Comparable <Vehiculo> {
    
    //Atributos: marca, matrícula, número de kilómetros, fecha de matriculación,  
    //descripción, precio, nombre del propietario, dni del propietario.
    
    private String marca, matricula, descripcion, nombrePropietario, dniPropietario;
    private double precio;
    private int kilometros;
    private LocalDate matriculacion;
    
    /**
     * Constructor del objeto vehículo.
     * @param marca marca del vehículo String
     * @param matricula matrícula del vehículo String
     * @param descripcion descripción del vehículo String
     * @param nombrePropietario nombre del propietario del vehículo String
     * @param dniPropietario dni del propietario del vehículo String
     * @param precio precio del vehículo double
     * @param kilometros kilómetros del vehículo int
     * @param matriculacion fecha de matriculación del vehículo LocalDate
     */
    public Vehiculo(String marca, String matricula, String descripcion, String nombrePropietario, String dniPropietario, double precio, int kilometros, LocalDate matriculacion) {
        this.marca = marca;
        this.matricula = matricula;
        this.descripcion = descripcion;
        this.nombrePropietario = nombrePropietario;
        this.dniPropietario = dniPropietario;
        this.precio = precio;
        this.kilometros = kilometros;
        this.matriculacion = matriculacion;
    }
    
    public String getMarca() {
        return marca;
    }
    
    public String getMatricula() {
        return matricula;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getNombrePropietario() {
        return nombrePropietario;
    }

    public String getDniPropietario() {
        return dniPropietario;
    }

    public double getPrecio() {
        return precio;
    }

    public LocalDate getMatriculacion() {
        return matriculacion;
    }
    
    public int getKilometros() {
        return kilometros;
    }

    //Retorna un entero con el número de años del vehículo.
    public int get_Anios() {
        int a = matriculacion.getYear();
        int b = LocalDate.now().getYear();
        return b-a;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setNombrePropietario(String nombrePropietario) {
        this.nombrePropietario = nombrePropietario;
    }

    public void setDniPropietario(String dniPropietario) {
        this.dniPropietario = dniPropietario;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setKilometros(int kilometros) {
        this.kilometros = kilometros;
    }

    public void setMatriculacion(LocalDate matriculacion) {
        this.matriculacion = matriculacion;
    }

    /*
    ob1.compareTo(ob2) < 0 si ob1 va antes que ob2.
    ob1.compareTo(ob2) > 0 si ob1 va después que ob2.
    ob1.compareTo(ob2) = 0 si ob1 es igual que ob2.
    */
    @Override
    public int compareTo(Vehiculo o) {
        return this.matricula.compareTo(o.getMatricula());
    }
}
