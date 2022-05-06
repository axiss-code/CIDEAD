/* Construye un nuevo proyecto Java denominado Prog03_Ejerc1.
En el proyecto debe aparecer un paquete, que no puede ser el paquete por defecto,
ponle el nombre que creas oportuno.
*/
package Tarea03;

//Crea una clase denominada Fecha. Esta clase no debe contener método main.
//La clase debe contener un atributo para el día, otro para mes (del tipo enumerado declarado) y un tercero para el año.
//Declara en el fichero de la clase un tipo enumerado, denominado enumMes, para los meses del año.

    enum enumMes { 
        ENERO,
        FEBRERO,
        MARZO,
        ABRIL,
        MAYO,
        JUNIO,
        JULIO,
        AGOSTO,
        SEPTIEMBRE,
        OCTUBRE,
        NOVIEMBRE,
        DICIEMBRE
    };

public class Fecha {
    
    //con private nos aseguramos que se cumpla la encapsulación
    private int dia, anio; 
    private enumMes mes;
  
    //Implementa un constructor que inicialice el mes al valor recibido por parámetro y los demás atributos a 0.    
    public Fecha(enumMes mes){
        
        this.mes = mes;
        this.dia=0; //dia y anio podrían omitirse, ya que por defecto si no se especifican
        this.anio=0; //java los inicializa a cero al ser de tipo int.
    }
    
    //Declara otro constructor que inicialice todos los atributos de la clase.
    public Fecha(int dia, enumMes mes, int anio) {
        this.dia = dia;
        this.anio = anio;
        this.mes = mes;
    }
    
    //Implementa los métodos que permitan acceder y modificar cada uno de los atributos de la clase.
    //Los nombres de dichos métodos serán: getXXX () para obtener el valor del atributo XXX
    //y setXXX (v) para actualizar el atributo XXX con el valor v.
    
    //metodo getter de día. Permitirá ver el valor almacenado en la variable
    public int getDia(){
        return dia;
    }
    
    //metodo setter de día. Permitirá cambiar el valor almacenado en la variable
    public void setDia(int dia){
        this.dia = dia;
    }
    
    //metodo getter de anio
    public int getAnio(){
        return anio;
    }
    
    //metodo setter de anio
    public void setAnio(int anio){
        this.anio = anio;
    }
    
    //metodo getter de mes
    public enumMes getMes() {
        return mes;
    }
    
    //metodo setter de mes
    public void setMes(enumMes mes) {
        this.mes = mes;
    }
    
    //Implementa un método que devuelva true si el valor contenido en la fecha es verano y false en caso contrario.
    public boolean isSummer(){
        return (this.mes == enumMes.JUNIO && this.dia > 20)
                || this.mes == enumMes.JULIO
                || this.mes == enumMes.AGOSTO
                || (this.mes == enumMes.SEPTIEMBRE && this.dia < 21);
    }
    
    //Implementa un método que devuelva una cadena con la fecha en formato largo,
    public String toString() {
        return dia + " de " + mes + " de " + anio;
    }
    
}