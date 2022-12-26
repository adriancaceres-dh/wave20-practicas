package com.bootcamp.transacciones;

public class Deposito implements ITransaccion{

    public void realizarDeposito(boolean ok) {
        if (ok) {
            transaccionOk();
        }
        else {
            transaccionNotOk();
        }
    }
    @Override
    public void transaccionOk() {
        System.out.println("Deposito realizado");
    }

    @Override
    public void transaccionNotOk() {
        System.out.println("Deposito no realizado");
    }
}
