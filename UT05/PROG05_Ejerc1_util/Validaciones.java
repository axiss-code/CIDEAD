/**
 * Clase para ejecutar las validaciones correspondientes a los datos
 * necesarios para crear un nuevo objeto Vehiculo.
 * Implementa comprobaciones para:
 * -DNI válido
 * -Kilometros mayor que cero
 * -Actualizacion de Kilometros >> solo se podrán sumar kilómetros.
 * -Fecha de matriculacion válida
 */
package PROG05_Ejerc1_util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.ResolverStyle;

public class Validaciones {
    
    // Cadena con las letras posibles del Validaciones ordenados para el cálculo de Validaciones
    private static final String LETRAS_DNI= "TRWAGMYFPDXBNJZSQVHLCKE";

    // Atributos de objeto
    private static int numDNI;
    
    //Validará si los kms son un numero positivo o lanzará una excepcion
    public static int esPositivo (int kilometros) throws Exception {
        if (kilometros <=0) { 
            throw new Exception ("Error. Introduce un valor mayor que 0.\n"); 
        } else {
        return kilometros;
        }
    }
    
    //Validará si los kms son mayores a los almacenados o lanzará una excepcion
    public static int esMayor (int x, int y) throws Exception {
        if (x<=y) { 
            throw new Exception ("Error. El valor introducido debe ser mayor al actual ["+y+" kms]\n"); 
        } else {
        return x;
        }
    }
    
    //Validará la fecha. Considerará:
    //Si el introducida con el fomato correspondiente dd-mm-aaaa
    //ResolverStyle.STRICT no permitirá fechas equivocadas, como 31-03 , o 29 feb cuando no es año bisiesto
    //Y si la fecha introducida es posterior a la actual, lanzará una excepción
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
    
    //Método que validará el NIF referenciado.
    public static String nuevoDNI (String nif) {
        
        if (Validaciones.validarNIF (nif)) { // Valor válido: lo almacenamos
            numDNI = Validaciones.extraerNumeroNIF(nif);
            return nif;
        }
        else {    
           return null;
        }
    }

    //Calcula la letra del NIF. Utilizado en validarNIF
    private static char calcularLetraNIF (int dni) {
        char letra;
        letra = LETRAS_DNI.charAt(dni % 23);       
        return letra; // Devolución de la letra NIF
    }

    // Extrae letra del NIF. Utilizado en validarNIF
    private static char extraerLetraNIF (String nif) {
        char letra=nif.charAt(nif.length()-1);
        return letra;
    }

    // Extrae el número del NIF. Utilizado en validarNIF
    private static int extraerNumeroNIF (String nif) {
        int numero= Integer.parseInt(nif.substring(0, nif.length()-1));
        return numero;
    }

    // Realiza comprobaciones sobre el NIF. Utilizado por nuevoDNI
    private static boolean validarNIF (String nif) {
        boolean valido = true;   // Suponemos el NIF válido mientras no se encuentre algún fallo
        
        if (nif == null || nif.equals("")) {
            System.out.println ("Error. Debe introducir un valor.");
            valido = false;
        } else if (nif.length()<8 || nif.length()>9) {
            System.out.println ("Error. La cadena debe estar entre 8(7+1) y 9(8+1) caracteres");
            valido = false;
       } else {
            char letra_leida;
            int  dni_leido;
            char letra_calculada;
            letra_leida = Character.toUpperCase(Validaciones.extraerLetraNIF (nif));    // Extraemos la letra de NIF (letra)
            dni_leido = Validaciones.extraerNumeroNIF (nif); //Extraemos el número de Validaciones (int)
            letra_calculada = Character.toUpperCase(Validaciones.calcularLetraNIF(dni_leido));  // Calculamos la letra de NIF a partir del número extraído
            
            
            if (letra_leida == letra_calculada) {   // Comparamos la letra extraída con la calculada
                valido = true; // Si todas las comprobaciones han resultado válidas. El NIF es válido.
            } else if (!Character.isLetter(letra_leida)){
                System.out.println ("Error. El último caracter ingresado debe ser una letra.");
                valido = false;
            } else {
                System.out.println ("Error. La letra ingresada no se corresponde con letra de control.");
                valido = false;
            }
        } 
        return valido;
    }  
}

