package Cuentas;

import Principal.Imprimible;
import java.io.Serializable;

public abstract class CuentaBancaria implements Imprimible, Serializable {
    
    private Persona titular;
    private double saldo;
    private String iban;

    public CuentaBancaria(Persona titular, double saldo, String iban) {
        this.titular = titular;
        this.saldo = saldo;
        this.iban = iban;
    }

    public String getTitular() {
        return titular.devolverInfoString();
    }

    public void setTitular(Persona titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }
    
    @Override
    public String devolverInfoString(){
        return (getTitular()+"\nSaldo: " +getSaldo()+"\nIBAN: "+getIban());
    }
    
    public String getNombreApellido() {
        return titular.devuelveNombreApellido();
    }

}
