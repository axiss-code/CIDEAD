/**
 * Tarea 05 - Clase Principal
 * Clase que implementará la lógica.
 * Restricciones:
 * - Solicitar datos por teclado y escribir datos en pantalla: esas operaciones se realizarán en la clase Principal.
 * - Los datos se validan en la clase Principal y si son correcto, se instancia el objeto Vehículo.
 * - La aplicación solo trabajará con un vehículo, por lo tanto, solo utilizará una referencia a un objeto de tipo Vehículo
 *   en la clase Principal. Si existe un vehículo y el usuario selecciona Nuevo Vehículo en el menú, se perderá la información
 *   del vehículo existente y se guardará la del nuevo.
 * - No será necesario realizar comprobaciones de tipo en los datos solicitados por teclado.
 * - Se debe incluir una excepción para la validación del DNI. Es decir, cuando no sea válido, se lanzará una excepción que
 *   se gestionará en la clase Principal, desde donde se mostrará el correspondiente mensaje de error.
 * - No se podrán mostrar datos de un vehículo si aún no se ha creado: en ese caso habrá que mostrar un mensaje por pantalla.
 */
package PROG05_Ejerc1;

import PROG05_Ejerc1_util.Validaciones;
import java.time.LocalDate;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Vehiculo car = null;
        boolean exit = false; //flag para salir del menu y finalizar

        System.out.println("- Aplicación de Vehículo -\n");
        //con do-while aseguramos que se muestre el menú al menos una vez.
        do {
            mostrarMenu(); //invocamos el menu en pantalla
            Scanner sc = new Scanner(System.in);

            try {
                int opcion = Integer.parseInt(sc.nextLine());

                switch (opcion) {  //para cualquier valor introducido distinto al rango 1...9, repetirá la pregunta
                    case 9:
                        System.out.println("Finalizado.");
                        exit = true; //El programa finalizará.
                        break;
                    case 8:
                        verPrecio(car);
                        break;
                    case 7:
                        datosVehiculo(car);
                        break;
                    case 6:
                        datosPropietario(car);
                        break;
                    case 5:
                        anios(car);
                        break;
                    case 4:
                        actualizaKms(car);
                        break;
                    case 3:
                        verKms(car);
                        break;
                    case 2:
                        verMatricula(car);
                        break;
                    case 1:
                        car = nuevoVehiculo();
                        break;
                    default:
                        System.out.println("Opción no válida.\n");
                }
            } catch (java.lang.NullPointerException e) {
                System.out.println("-- Fallo --\nPrimero se debe crear un Nuevo Vehiculo!\n");
            } catch (java.lang.NumberFormatException e) {
                System.out.println("Opción no válida.\n");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (exit != true); //el bucle se interrumpirá al introducir un 9 -> exit cambia de valor a true.

    }

    //Método para mostrar el menu de opciones por pantalla. OKKK
    static void mostrarMenu() {
        System.out.print("1. Nuevo Vehículo."
                + "\n2. Ver Matrícula."
                + "\n3. Ver Número de Kilómetros."
                + "\n4. Actualizar Kilómetros."
                + "\n5. Ver años de Antigüedad."
                + "\n6. Mostrar Propietario."
                + "\n7. Mostrar Descripción."
                + "\n8. Mostrar Precio."
                + "\n9. Salir."
                + "\n\nElige una opción: ");
    }

    /**
     * Método para crear un nuevo objeto de Vehiculo. Pedirá por teclado: marca,
     * matrícula, número de kilómetros, fecha de matriculación, descripción,
     * precio, nombre del propietario, dni del propietario. Se comprobará que: -
     * la fecha de matriculación es anterior a la actual. - el número de
     * kilómetros es mayor que 0. - el DNI del propietario es correcto. (Si no
     * se cumple mostrará el correspondiente mensaje de error y se volverá al
     * menú principal)
     */
    static Vehiculo nuevoVehiculo() {
        /*  Constructor de Vehiculo (
         *  String marca
         *  String matricula
         *  String descripcion
         *  String nombrePropietario
         *  String dniPropietario
         *  int kilometros
         *  double precio
         *  LocalDate matriculacion )
         */
        Vehiculo x = null; //Instanciamos x como null -> con el constructor adoptará los valores enviados por teclado.

        System.out.println("A continuación introduce los datos necesarios"
                + " para la creación de un nuevo Vehículo.\n");
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Marca: ");
            String marca = sc.nextLine();

            System.out.print("Matrícula: ");
            String matricula = sc.nextLine();

            System.out.print("Descripción: ");
            String descripcion = sc.nextLine();

            System.out.print("Propietario: ");
            String nombrePropietario = sc.nextLine();

            System.out.print("DNI del Propietario: ");
            String DNI = sc.nextLine();
            String dniPropietario;
            if (Validaciones.nuevoDNI(DNI) != null) {
                dniPropietario = DNI;
            } else {
                throw new Exception("DNI inválido.\n");
            }

            System.out.print("Nº de kilómetros (sin decimales): ");
            int kms = (Integer.parseInt(sc.nextLine()));
            int kilometros = Validaciones.esPositivo(kms);

            System.out.print("Precio: ");
            double precio = Double.parseDouble(sc.nextLine());

            System.out.print("Fecha de Matriculacion (dd-mm-aaaa): ");
            String fechaMat = sc.nextLine();
            LocalDate matriculacion = Validaciones.fechaOK(fechaMat);

            //Constructor 
            x = new Vehiculo(marca, matricula, descripcion, nombrePropietario, dniPropietario, precio, kilometros, matriculacion);
            System.out.println("Vehículo creado correctamente!\n");
        } catch (java.lang.NumberFormatException e) {
            System.out.println("Error. Se esperaba otro valor.\n");
        } catch (java.time.format.DateTimeParseException e) {
            System.out.println("Error. Fecha / formato inválidos.\nSe esperaba \"dd-mm-aaaa\" (ej. 15-10-2010)\n");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            System.out.println("Error. Se esperaba un valor.\n");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        //Si los valores introducidos no son válidos, x seguirá siendo null, por tanto devolverá null
        return x;
    }

    //Mostrará la matrícula del vehículo por pantalla (2)
    static void verMatricula(Vehiculo x) {
        
        System.out.println(x.getMatricula().equals("") ? "\nLa matrícula es: (Vacío)" : "\nLa matrícula es: "+x.getMatricula());
        continuar();
    }

    //Mostrará el número de kilómetros por pantalla (3)
    static void verKms(Vehiculo x) {

        System.out.println("\nLos kilómetros son: " + x.getKilometros());
        continuar();
    }

    //Permitirá actualizar el número de kilómetros del vehículo.
    //Habrá que tener en cuenta que solo se podrán sumar kilómetros. (4)  
    static void actualizaKms(Vehiculo x) throws Exception {
        System.out.print("\nNuevo nº de kilómetros: ");
        Scanner sc = new Scanner(System.in);
        int kms = (Integer.parseInt(sc.nextLine()));
        x.setKilometros(Validaciones.esMayor(kms, x.getKilometros()));
        System.out.println("Kms. actualizados correctamente.");
        continuar();
    }

    //Mostrará por pantalla el número de años del vehículo desde que se matriculó, no la fecha de matriculación. (5)
    static void anios(Vehiculo x) {

        System.out.println("Antigüedad del Vehículo (en años): " + x.get_Anios());
        System.out.println("[Fue matriculado el " + x.getMatriculacion() + "]");
        continuar();
    }

    //Mostrará por pantalla el nombre del propietario del vehículo junto a su DNI. (6)
    static void datosPropietario(Vehiculo x) {
        
        System.out.println(x.getNombrePropietario().equals("") ? "\nNombre del Propietario: (Vacío)" : "\nNombre del Propietario: " + x.getNombrePropietario());
        System.out.println("DNI del Propietario: " + x.getDniPropietario());
        continuar();
    }

    //Mostrará una descripción del vehículo, incluyendo su matrícula y el número de kilómetros que tiene. (7)
    static void datosVehiculo(Vehiculo x) {
       
        System.out.println(x.getMatricula().equals("") ? "\nMatrícula Nº:\t(Vacío)" : "\nMatrícula Nº:\t"+x.getMatricula());
        System.out.println("Kilometros:\t" + x.getKilometros());
        System.out.println(x.getDescripcion().equals("") ? "Descripción:\t(Vacío)" : "Descripción:\t"+x.getDescripcion());
        continuar();
    }

    //Mostrará el precio del vehículo. (8)
    static void verPrecio(Vehiculo x) {
        System.out.println("\nEl precio es: " + x.getPrecio());
        continuar();
    }

    //Metodo "Presiona INTRO para continuar".
    static void continuar() {
        System.out.println("(INTRO para continuar)...");
        try {
            System.in.read();
        } catch (Exception e) {
        }
    }
}
