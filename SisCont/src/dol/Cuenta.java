package dol;

import java.io.Serializable;

public class Cuenta implements Serializable{
    private String cuenta;
    private Double efectivo;

    public Cuenta(String cuenta, Double efectivo) {
        this.cuenta = cuenta;
        this.efectivo = efectivo;
    }

    public Cuenta() {
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public Double getEfectivo() {
        return efectivo;
    }

    public void setEfectivo(Double efectivo) {
        this.efectivo = efectivo;
    }

    @Override
    public String toString() {
        return " Cuenta{" + "cuenta=" + cuenta + ", efectivo=" + efectivo + '}';
    }
    
}
