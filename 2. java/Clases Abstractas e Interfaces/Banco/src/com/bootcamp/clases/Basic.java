package com.bootcamp.clases;

import com.bootcamp.intefaces.IConsultarSaldo;
import com.bootcamp.intefaces.IPagoServicios;
import com.bootcamp.intefaces.IRetiroEfectivo;

public class Basic extends Cliente implements IConsultarSaldo, IPagoServicios, IRetiroEfectivo {
    public Basic(String nombre, double montoDisponible) {
        super(nombre, montoDisponible);
    }

    public Basic() {
    }

    @Override
    public void hacerConsultaSaldo() {
        System.out.println("Su saldo disponible es " + getMontoDisponible() + ".");
    }

    @Override
    public boolean hacerPagoServicios(String servicio, double monto) {
        double montoDisponible = getMontoDisponible();
        if (montoDisponible >= monto) {
            System.out.println("Se pagó el servicio " + servicio + " con un monto de $" + monto + ".");
            setMontoDisponible(montoDisponible - monto);
            return true;
        }
        System.out.println("No se ha podido pagar el servicio " + servicio + " con un monto de $" + monto + ", saldo insuficiente.");
        return false;
    }

    @Override
    public boolean hacerRetiroEfectivo(double monto) {
        double montoDisponible = getMontoDisponible();
        if (montoDisponible >= monto) {
            System.out.println("Se ha retirado $" + monto + " de su saldo disponible.");
            setMontoDisponible(montoDisponible - monto);
            return true;
        }
        System.out.println("No se ha podido retirar $" + monto + ", saldo insuficiente.");
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
