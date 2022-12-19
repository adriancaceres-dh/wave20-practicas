package com.bootcamp.ej1;

import com.bootcamp.ej1.transacciones.*;


public class Basic implements IConsultaSaldo, IPagoServicios, IRetiroEfectivo {

    @Override
    public boolean transaccionOk() {
        return true;
    }

    @Override
    public boolean transaccionNoOk() {
        return false;
    }

    @Override
    public void consultar() {
        System.out.println("Consultando...");
    }

    @Override
    public void pagar() {
        System.out.println("Pagando...");
    }

    @Override
    public void retirar() {
        System.out.println("Retirando efectivo...");
    }
}

