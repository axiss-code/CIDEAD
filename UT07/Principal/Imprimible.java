package Principal;

/**
 * La interfaz Imprimible tan solo declarará el devolverInfoString, que devolverá la información de una
 * cuenta como una cadena de caracteres.
 */
public interface Imprimible {
    
    /**
     * Método que devolverá información de tipo String en la clase que lo implemente.
     * @return String
     */
    String devolverInfoString();    
}