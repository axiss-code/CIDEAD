package Cuentas;

/**
 * Las cuentas corrientes de empresa permiten tener una cierta cantidad de descubierto (máximo descubierto permitido)
 * y por tanto un tipo de interés por descubierto y una comisión fija por cada descubierto que se tenga.
 * Es el único tipo de cuenta que permite tener descubiertos.
 */
public class CuentaCorrienteEmpresa extends CuentaCorriente {
    
    private double tipoInteresDescubierto;
    private double maximoDescubiertoPermitido;
    private double comisionFijaDescubierto;

    public CuentaCorrienteEmpresa(Persona titular, double saldo, String iban, String entidadesAutorizadas,
            double tipoInteresDescubierto, double maximoDescubiertoPermitido, double comisionFijaDescubierto) {
        super(titular, saldo, iban, entidadesAutorizadas);
        this.tipoInteresDescubierto = tipoInteresDescubierto;
        this.maximoDescubiertoPermitido = maximoDescubiertoPermitido;
        this.comisionFijaDescubierto = comisionFijaDescubierto;
    }

    public double getTipoInteresDescubierto() {
        return tipoInteresDescubierto;
    }

    public void setTipoInteresDescubierto(double tipoInteresDescubierto) {
        this.tipoInteresDescubierto = tipoInteresDescubierto;
    }
    
    public double getMaximoDescubiertoPermitido() {
        return maximoDescubiertoPermitido;
    }

    public void setMaximoDescubiertoPermitido(double maximoDescubiertoPermitido) {
        this.maximoDescubiertoPermitido = maximoDescubiertoPermitido;
    }

    public double getComisionFijaDescubierto() {
        return comisionFijaDescubierto;
    }

    public void setComisionFijaDescubierto(double comisionFijaDescubierto) {
        this.comisionFijaDescubierto = comisionFijaDescubierto;
    }
    
    @Override 
    public String devolverStringInfo(){
        return (super.devolverStringInfo()+"\nTipo de interés por descubierto: "+getTipoInteresDescubierto()+
                "\nMáximo descubierto permitido: "+getMaximoDescubiertoPermitido()+
                "\nComisión fija por descubierto: "+getComisionFijaDescubierto());
    } 
}

