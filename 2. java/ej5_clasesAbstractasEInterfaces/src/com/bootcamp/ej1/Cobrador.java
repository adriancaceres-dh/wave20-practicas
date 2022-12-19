package com.bootcamp.ej1;

import com.bootcamp.ej1.transacciones.*;


public class Cobrador implements IRetiroEfectivo, IConsultaSaldo{

    @Override
    public boolean transaccionOk() {
        return true;
    }

    @Override
    public boolean transaccionNoOk() {
        return false;
    }

    @Override
    public void retirar() {
        System.out.println("Retirando...");
    }

    @Override
    public void consultar() {
        System.out.println("Consultando...");
    }
}
