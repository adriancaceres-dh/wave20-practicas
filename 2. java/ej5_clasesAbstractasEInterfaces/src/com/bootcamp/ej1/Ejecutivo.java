package com.bootcamp.ej1;

import com.bootcamp.ej1.transacciones.*;


public class Ejecutivo implements IDeposito, ITransferencia{

    @Override
    public boolean transaccionNoOk() {
        return false;
    }

    @Override
    public boolean transaccionOk() {
        return true;
    }

    @Override
    public void depositar() {
        System.out.println("Depositando...");
    }

    @Override
    public void transferir() {
        System.out.println("Transfiriendo...");
    }
}
