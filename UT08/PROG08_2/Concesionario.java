/*
 * Tarea 06 - Clase Concesionario
 * 
 * Esta clase deberá contener la estructura de datos necesaria para almacenar los vehículos, con un tamaño máximo
 * de 50. Por otro lado, ten en cuenta que para saber el número de vehículo existentes en la citada estructura,
 * deberás utilizar un atributo de tipo entero. Este atributo te permitirá conocer la posición de inserción de un nuevo vehículo
 * o hasta qué posición debes recorrer la estructura.
 * Sus métodos serán:
 * - Constructor o constructores.
 * - buscaVehículo: Recibe como parámetro una matrícula, buscar el vehículo en el concesionario y devuelve una cadena con los datos del vehículo
 *   o null si el vehículo buscado no existe.
 * - insertarVehiculo: Recibe todos los datos de un vehículo y trata de insertarlo en el concesionario. Devuelve 0 si se hizo con éxito,
 *   -1 si el concesionario esta lleno y -2 si la matrícula ya existe.
 * - listaVehículos: Lista por pantalla los datos de todos los vehículos del concesionario.
 * - actualizaKms: Recibe por parámetro una matrícula y un número de kilómetros, busca el vehículo cuya matrícula coincida y
 *   actualiza sus kilómetros. Devuelve true si se hizo con éxito y false en caso contrario.
 *
 * Restricciones:
 * - El concesionario será capaz de gestionar un máximo de 50 coches.
 * - Los métodos de la clase Concesionario no deben mostrar datos por pantalla, a excepción del método que liste los vehículos.
 *   Estos métodos deben devolver un valor indicando si la operación se realizó correctamente o no.
 */
package PROG08_2;

import java.time.LocalDate;
import java.util.TreeSet;

public class Concesionario {
    
    private final TreeSet<Vehiculo> cars;
    
    //Constructor que nos creará un Array con capacidad para 50 objetos de la clase Vehiculo
    //con inicialización de contador a 0
    public Concesionario(){
        this.cars = new TreeSet<>();
    }

    //Accederemos desde la clase Principal para determinar si hay objetos creados.
    public int getContador() {
        return cars.size();
    }
    
    /**
     * Recibe como parámetro una matrícula, busca el vehículo en el concesionario y devuelve una cadena con
     * los datos del vehículo (marca, matricula, precio) o null si el vehículo buscado no existe.
     * @param matricula String
     * @return Un String con (marca + matricula + precio) o null
     */
    public String buscaVehiculo(String matricula){
        String respuesta = null;
        for (Vehiculo c : cars) {
            if(c.getMatricula().equals(matricula)){
                respuesta="Marca: "+c.getMarca()+"\nMatricula: "+c.getMatricula()+"\nPrecio: "+c.getPrecio();
            }
        }
        return respuesta;
    }
    
    /**
     * Método que recibe todos los parámetros requeridos, y validados, para poder crear un nuevo objeto Vehiculo.
     * El objeto creado se añade al Concesionario, siempre y cuando la matrícula no exista ya o que el mismo esté lleno (max.50)
     * @return -2 si la matrícula ya existe, 0 si se añadió con éxito el nuevo objeto
     */
    public int insertarVehiculo (String marca, String matricula, String descripcion, String nombrePropietario,
            String dniPropietario, double precio, int kilometros, LocalDate matriculacion) {
        
        //Llamada al constructor de la clase Vehiculo, creada en la Tarea5
        Vehiculo car = new Vehiculo (marca, matricula, descripcion, nombrePropietario, dniPropietario, precio, kilometros, matriculacion);
        
        if (buscaVehiculo(car.getMatricula()) != null) {
            return -2;
        } else {
            cars.add(car);
            return 0;
        } 
    }
    
    //Lista por pantalla los datos de todos los vehículos del concesionario.
    //Marca, Matrícula, Precio, Kilómetros y Descripción de cada uno.
    public void listaVehiculos() {
        if (cars.isEmpty()) {
            System.out.println("Concesionario vacío.");   
        } else {
            for (Vehiculo c : cars) {
                System.out.println();
                System.out.println("Marca:\t\t"+c.getMarca());
                System.out.println("Matrícula:\t"+c.getMatricula());
                System.out.println("Precio:\t\t"+c.getPrecio());
                System.out.println("Kilómetros:\t"+c.getKilometros());
                System.out.println("Descripción:\t"+c.getDescripcion());
            }
        }
    }
    
    //Recibe por parámetro una matrícula y un número de kilómetros, busca el vehículo cuya matrícula coincida
    //y actualiza sus kilómetros. Devuelve true si se hizo con éxito y false en caso contrario.
    public boolean actualizaKms(String matricula, int kms) {       
        for (Vehiculo c : cars) {
            if(c.getMatricula().equals(matricula)) {
                c.setKilometros(kms);
                return true;
            }
        }
        return false;
    }
    
    //Elimina del concesionario el vehículo cuya matrícula coincida
    //Mueve el último objeto de la cola, a la ubicación del objeto borrado y decrece el contador en 1
    public boolean borraVehiculo (String matricula) {       
        for (Vehiculo c : cars) {
            if(c.getMatricula().equals(matricula)) {
                cars.remove(c);
                return true;
            }
        }
        return false;
    }
}
