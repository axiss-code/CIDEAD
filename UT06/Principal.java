/**
 * Tarea 06 - Clase Principal
 * 
 * Clase que se encargue de:
 * ..Instanciar un objeto Concesionario.
 * ..Pintar el menú y solicitar datos por teclado al usuario.
 * ..Realizar las validaciones de datos de entrada.
 * ..Mostrar datos por pantalla.
 * 
 * Restricciones:
 * - Evitar el uso de la clase Vehiculo desde la clase Principal. Solo se debe utilizar la clase Concesionario.
 * - Para añadir un nuevo vehículo se deberá validar:
 *      - Mediante expresiones regulares que:
 *          - El DNI del propietario es correcto (tan solo el formato).
 *          - La matrícula del vehículo es correcta (tan solo el formato), es decir, tiene el formato NNNNLLL,
 *            donde NNNN es un número entre 0000 y 9999 y LLL son letras mayúsculas del abecedario.
 *      - Sin expresiones regulares (utilizando métodos de la clase String):
 *          - Que el nombre del propietario contenga al menos un nombre y dos apellidos (no tratar nombres
 *            compuestos) y su longitud no excede de 40 caracteres.
 *      - Habrá que comprobar que no existe en el concesionario un vehículo con la matrícula introducida.
 *        En caso afirmativo, se mostrará un mensaje por pantalla y mostrará el menú.
 */
package PROG06;

import java.time.LocalDate;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.ResolverStyle;

public class Principal {
    
    //Opción cosmética que mostrará en rojo el mensaje por pantalla
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    

    public static void main(String[] args) {

        Concesionario carshop = new Concesionario();
        boolean exit = false; //flag para salir del menu y finalizar

        System.out.println("-= Aplicación de Concesionario =-");
        //con do-while aseguramos que se muestre el menú al menos una vez.
        do {
            mostrarMenu(); //invocamos el menu en pantalla
            Scanner sc = new Scanner(System.in);

            try {
                int opcion = Integer.parseInt(sc.nextLine());

                switch (opcion) {  //para cualquier valor introducido distinto al rango 1...6, repetirá la pregunta
                    case 6:
                        System.out.println("Finalizado.");
                        exit = true; //El programa finalizará.
                        break;
                    case 5:
                        eliminarVehiculo(carshop);
                        break;
                    case 4:
                        modificarKms(carshop);
                        break;
                    case 3:                       
                        buscarVehiculo(carshop);
                        break;
                    case 2:
                        if (carshop.getContador() == 0) {
                            System.out.println(ANSI_RED+"Concesionario vacío."+ANSI_RESET);   
                        } else {
                            carshop.listaVehiculos();
                        }
                        break;
                    case 1:
                        nuevoVehiculo(carshop);
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (java.lang.NumberFormatException e) {
                System.out.println("Opción no válida.\n");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (exit != true); //el bucle se interrumpirá al introducir un 6 -> exit cambia de valor a true.
    }

    //Método para mostrar el menu de opciones por pantalla. 
    static void mostrarMenu() {
        System.out.print("\nMenú Principal:"
                + "\n1. Nuevo Vehículo."
                + "\n2. Listar Vehículos."
                + "\n3. Buscar Vehículo."
                + "\n4. Modificar Kilómetros Vehículo."
                + "\n5. Eliminar Vehículo."
                + "\n6. Salir."
                + "\n\nElige una opción: ");
    }
    
    /* El Constructor de Vehiculo necesita los siguientes atributos, que serán enviados a la clase Concesionario
     * que se encargará de crea el nuevo Vehiculo, dado que se debe evitar el uso de la clase Vehiculo desde la clase Principal. 
     * String marca, matricula, descripcion, nombrePropietario, String dniPropietario; 
     * int kilometros; double precio; LocalDate matriculacion 
     */
    static void nuevoVehiculo(Concesionario concesionarioGenerico) {
        String marca, matricula, descripcion, nombrePropietario, dniPropietario;
        int kilometros;
        double precio;
        LocalDate matriculacion;
        
        System.out.println("Introduce todos los datos para crear un nuevo Vehículo.\n");
        Scanner sc = new Scanner(System.in);
        
        //Marca
        System.out.print("Marca: ");
        marca = sc.nextLine();
        
        //Matricula, con validación NNNNLLL
        matricula = null;
        do {
            System.out.println(null == matricula ? "Matrícula del vehículo (NNNNLLL sin espacios)" : "Formato no válido. Deben ser 4 números y 3 letras mayúsculas. Ej: 1234ABC.");
            System.out.print("Matrícula: ");
            matricula = sc.nextLine();
        } while (!validarMatricula(matricula));

        System.out.print("Descripción: ");
        descripcion = sc.nextLine();
        
        //nombrePropietario con validación isCharSpace y length
        nombrePropietario = null;
        do {
            System.out.print(null == nombrePropietario ? "Nombre y Apellidos del " : "Fallo. UN nombre y DOS apellidos (max. 40 caracteres)\n");
            System.out.print("Propietario: ");
            nombrePropietario = sc.nextLine();
        } while (!validarNombre(nombrePropietario));
        
        //dniPropietario, con validación NNNNNNNNL
        dniPropietario = null;
        do {
            System.out.print(null == dniPropietario ? "DNI del propietario " : "Formato no válido. Deben ser 8 números + 1 letra mayúscula\n");
            System.out.print("(NNNNNNNNL): ");
            dniPropietario = sc.nextLine();
        } while (!validarDni(dniPropietario));
        
        //kilometros, con validación >=0 y nº entero
        kilometros = -1;
        do {
            try {
                System.out.print("Nº de kilómetros (sin decimales): ");
                int kms = (Integer.parseInt(sc.nextLine()));
                kilometros = esPositivo(kms);
            } catch (java.lang.NumberFormatException e) {
                System.out.println("Opción no válida.");
            } catch (Exception e) {
                System.out.println(e.getMessage());  
            }  
        } while (kilometros<0);

        System.out.print("Precio: ");
        precio = Double.parseDouble(sc.nextLine());
        
        //fecha de matriculación, con validación fecha válida e igual o < que hoy
        matriculacion = null;
        do {
            try {
                System.out.print("Fecha de Matriculacion (dd-mm-aaaa): ");
                String fecha = sc.nextLine();
                matriculacion = fechaOK(fecha);
            } catch (java.time.format.DateTimeParseException e) {
                System.out.println("Error. Fecha / formato inválidos.\nSe esperaba \"dd-mm-aaaa\" (ej. 15-10-2010)\n");
            } catch (Exception e) {
                System.out.println(e.getMessage());  
            }
        } while (matriculacion == null);
        
        //envío de datos y respuesta de si se ha creado el nuevo vehículo desde la clase Concesionario
        //0 = exitosamente, -1 = concecionario lleno, -2 = matrícula existente en concesionario
        switch (concesionarioGenerico.insertarVehiculo(marca, matricula, descripcion, nombrePropietario, dniPropietario, precio, kilometros, matriculacion)) {
            case -2:
                System.out.println("\nEl vehículo con la matrícula "+matricula+" ya existe en el concesionario.");
                break;
            case -1:
                System.out.println("\nConcesionario lleno (max. 50 vehículos).");
                break;
            case 0:
                System.out.println("\nVehículo agregado correctamente al concesionario.");
                break;
        }
    }    
    
    //Se solicitará al usuario una matrícula por teclado (no será necesario validarla) y se buscará en el concesionarioGenerico
    //un vehículo cuya matrícula coincida con la introducida. Si existe se mostrarán su marca, matrícula y precio
    //por pantalla y en caso contrario el mensaje "No existe vehículo con la matrícula introducida".
    static void buscarVehiculo(Concesionario concesionarioGenerico) {
        if (concesionarioGenerico.getContador() != 0) {
            Scanner sc = new Scanner(System.in);
            System.out.print("-> Matrícula a buscar: ");
            String matricula = sc.nextLine();
            var respuesta = concesionarioGenerico.buscaVehiculo(matricula);
            if (respuesta==null) {
                System.out.println("\nNo existe ningún vehículo con la matrícula introducida.");
            } else {
                System.out.println(respuesta);
            }
        } else {
            System.out.println(ANSI_RED+"Concesionario vacío."+ANSI_RESET);
        }
    }
    
    //Se solicitará al usuario por teclado una matrícula y un número de kilómetros.
    //Si el vehículo con esa matrícula existe, se actualizará su número de kms al valor introducido. 
    //Si no existe, se mostrará un mensaje por pantalla.
    static void modificarKms (Concesionario concesionarioGenerico) {
        if (concesionarioGenerico.getContador() != 0) {
            Scanner sc = new Scanner(System.in);
            System.out.print("-> Matricula del Vehículo: ");
            String matricula = sc.nextLine();
            System.out.print("-> Kilómetros: ");
            int kms = (Integer.parseInt(sc.nextLine()));
            if (concesionarioGenerico.actualizaKms(matricula, kms)) {
                System.out.println("Kms. actualizados correctamente.");
            } else {
                System.out.println("Matrícula no encontrada.");
            }
        } else {
            System.out.println(ANSI_RED+"Concesionario vacío."+ANSI_RESET);
        }
    }
    
    //Solicitada una matrícula, elimina del concesionario el vehículo cuya matrícula coincida
    //La posición que ocupe el objeto-vehículo en el array que se borra, será reemplazada por el último objeto introducido
    //cuyo índice será igual a (contador-1), al no tratarse de un Array ordenado.
    static void eliminarVehiculo (Concesionario concesionarioGenerico) {
        if (concesionarioGenerico.getContador() != 0) {
            Scanner sc = new Scanner(System.in);
            System.out.print("-> Matricula del Vehículo a eliminar (NNNNLLL): ");
            String matricula = sc.nextLine();
            if (validarMatricula(matricula)) {
                var respuesta = concesionarioGenerico.buscaVehiculo(matricula);
                if (respuesta==null) {
                    System.out.println("\nNo existe ningún vehículo con la matrícula introducida."); 
                } else {
                    concesionarioGenerico.borraVehiculo(matricula);
                    System.out.println("\nVehículo borrado.");
                }
            } else {
                System.out.println("Formato no válido. Deben ser 4 números y 3 letras mayúsculas. Ej: 1234ABC.");
            }
        } else {
            System.out.println(ANSI_RED+"Concesionario vacío."+ANSI_RESET);
        }
    }
    
    // ********************  VALIDACIONES  ********************
    
    //Valida mediante expresiones regulares que la matrícula es correcta si cumple el formato es NNNNLLL,
    //donde NNNN es un número entre 0000 y 9999 y LLL son letras mayúsculas del abecedario.
    public static boolean validarMatricula (String matricula) {
        return matricula.matches("^[0-9]{4}[A-Z]{3}$");
    }
    
    //Valida mediante expresiones regulares que el DNI es correcto (tan solo el formato NNNNNNNNL).
    public static boolean validarDni (String dni) { 
       return dni.matches("^[0-9]{8}[a-zA-Z]$");
    }
    
    /**
     * Validará Que el nombre del propietario contenga al menos un nombre y dos apellidos (no tratar nombres compuestos)
     * y su longitud no excede de 40 caracteres
     * @return false si es mayor de 40 caracteres o si no encuentra 2 o + espacios en blanco en nombre&apellidos
     */
    public static boolean validarNombre (String nombre) {
        if (nombre.length() > 40) return false;
        int contador=0;
        for (int i=0; i<nombre.length(); i++) {
            char c = nombre.charAt(i);
            if (Character.isSpaceChar(c)) contador++;
        }
        return (contador>1);
    }
    
    //Validará si los kms son un número positivo o lanzará una excepcion
    //Validación reutilizada de la Tarea5
    public static int esPositivo (int kilometros) throws Exception {
        if (kilometros <=0) { 
            throw new Exception ("Error. Introduce un valor mayor que 0."); 
        } else {
        return kilometros;
        }
    }
    
    //Validará la fecha. Considerará si el introducida con el fomato correspondiente dd-mm-aaaa
    //ResolverStyle.STRICT no permitirá fechas equivocas, como 31-04 , o 29 feb cuando no es año bisiesto
    //Y si la fecha introducida es posterior a la actual, lanzará una excepción
    //Validación reutilizada de la Tarea5
    public static LocalDate fechaOK (String fec) throws Exception {
        DateTimeFormatter format = new DateTimeFormatterBuilder()
            .appendPattern("d-M-uuuu")
            .toFormatter()
            .withResolverStyle(ResolverStyle.STRICT);
        LocalDate fecha = LocalDate.parse(fec, format);
          
        if (fecha.isAfter(LocalDate.now())){
            throw new Exception ("Error. La fecha debe ser anterior a hoy.");
        } else {
            return fecha;
        }
    }
}
