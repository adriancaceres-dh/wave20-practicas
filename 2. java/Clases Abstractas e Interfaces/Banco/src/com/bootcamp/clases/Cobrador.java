package com.bootcamp.clases;

import com.bootcamp.intefaces.IConsultarSaldo;
import com.bootcamp.intefaces.IRetiroEfectivo;

public class Cobrador extends Cliente implements IRetiroEfectivo, IConsultarSaldo {

    public Cobrador(String nombre, double montoDisponible) {
        super(nombre, montoDisponible);
    }

    public Cobrador() {
    }

    @Override
    public void hacerConsultaSaldo() {
        System.out.println("Su saldo disponible es " + getMontoDisponible() + ".");
    }

    @Override
    public boolean hacerRetiroEfectivo(double monto) {
        double montoDisponible = getMontoDisponible();
        if (montoDisponible >=  monto){
            System.out.println("Se ha retirado $"+ monto +" de su saldo disponible.");
            setMontoDisponible(montoDisponible-monto);
            return true;
        }
        System.out.println("No se ha podido retirar $"+ monto +", saldo insuficiente.");
        return false;
    }

    @Override
    public void transaccionOk(String tipoTransaccion) {
        System.out.println("La transacción " + tipoTransaccion +  " se realizó correctamente.");
    }

    @Override
    public void transaccionNoOk(String tipoTransaccion) {
        System.out.println("La transacción " + tipoTransaccion +  " no se pudo realizar.");
    }

}
