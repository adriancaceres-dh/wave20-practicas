package com.bootcamp.clases;

import com.bootcamp.intefaces.IDeposito;
import com.bootcamp.intefaces.ITransferencia;

public class Ejecutivo extends Cliente implements IDeposito, ITransferencia {

    public Ejecutivo(String nombre, double montoDisponible) {
        super(nombre, montoDisponible);
    }

    public Ejecutivo() {
    }

    @Override
    public void hacerDeposito(double monto) {
        double montoDisponible = getMontoDisponible();
        System.out.println("Se ha depositado $" + monto + " a su saldo disponible.");
        setMontoDisponible(montoDisponible + monto);
    }

    @Override
    public boolean hacerTransferencia(double monto, String nroCuenta) {
        double montoDisponible = getMontoDisponible();
        if (montoDisponible >=  monto){
            System.out.println("Se ha transferido $"+ monto +" a la cuenta "+nroCuenta +".");
            setMontoDisponible(montoDisponible-monto);
            return true;
        }
        System.out.println("No se ha podido transferir $"+ monto +" a la cuenta "+nroCuenta +", saldo insuficiente.");
        return false;
    }

    @Override
    public void transaccionOk(String tipoTransaccion) {
        System.out.println("La transacción " + tipoTransaccion + " se realizó correctamente.");
    }

    @Override
    public void transaccionNoOk(String tipoTransaccion) {
        System.out.println("La transacción " + tipoTransaccion + " no se pudo realizar.");
    }
}
