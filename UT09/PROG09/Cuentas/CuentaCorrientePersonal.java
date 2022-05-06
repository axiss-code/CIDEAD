package Cuentas;

//Las cuentas corrientes personales tienen una comisión de mantenimiento.
public class CuentaCorrientePersonal extends CuentaCorriente{
    
    private double comisionMantenimiento;

    public CuentaCorrientePersonal(Persona titular, double saldo, String iban, String entidadesAutorizadas, double comisionMantenimiento) {
        super(titular, saldo, iban, entidadesAutorizadas);
        this.comisionMantenimiento = comisionMantenimiento;
    }

    public double getComisionMantenimiento() {
        return comisionMantenimiento;
    }

    public void setComisionMantenimiento(double comisionMantenimiento) {
        this.comisionMantenimiento = comisionMantenimiento;
    }
    
    @Override
    public String devolverStringInfo(){
        return (super.devolverStringInfo()+"\nComisión de mantenimiento: "+getComisionMantenimiento());
    }
}
