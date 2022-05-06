package Cuentas;

//Las cuentas corrientes tienen asociada una lista de entidades autorizadas para cobrar recibos domiciliados en la cuenta
public abstract class CuentaCorriente extends CuentaBancaria {
    
    private String entidadesAutorizadas;

    public CuentaCorriente(Persona titular, double saldo, String iban, String entidadesAutorizadas) {
        super(titular, saldo, iban);
        this.entidadesAutorizadas = entidadesAutorizadas;
    }

    public String getEntidadesAutorizadas() {
        return entidadesAutorizadas;
    }

    public void setEntidadesAutorizadas(String entidadesAutorizadas) {
        this.entidadesAutorizadas = entidadesAutorizadas;
    }
    
    public String devolverStringInfo(){
        return (super.devolverInfoString()+"\nEntidades Autorizadas: "+getEntidadesAutorizadas());
    }
}
