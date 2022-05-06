package Cuentas;


//Las cuentas de ahorro son remuneradas y tienen un determinado tipo de interés
public class CuentaAhorro extends CuentaBancaria {
    
    private double tipoInteres;
    
    //Constructor de CuentaAhorro
    public CuentaAhorro(Persona titular, double saldo, String iban, double tipoInteres) {
        super(titular, saldo, iban); //Llamamos al constructor de CuentaBancaria
        this.tipoInteres = tipoInteres;
    }

    public double getTipoInteres() {
        return tipoInteres;
    }

    public void setTipoInteres(double tipoInteres) {
        this.tipoInteres = tipoInteres;
    }
    
    public String devolverStringInfo(){
        return (super.devolverInfoString()+"\nTipo de Interés: "+getTipoInteres());
    }
}

