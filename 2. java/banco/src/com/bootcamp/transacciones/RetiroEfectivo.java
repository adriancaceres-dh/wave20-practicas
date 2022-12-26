package com.bootcamp.transacciones;

public class RetiroEfectivo implements ITransaccion{

    public void realizarRetiro(boolean ok) {
        if (ok) {
            transaccionOk();
        }
        else {
            transaccionNotOk();
        }
    }
    @Override
    public void transaccionOk() {
        System.out.println("Retiro de efectivo realizado");
    }

    @Override
    public void transaccionNotOk() {
        System.out.println("Retiro de efectivo no realizado");
    }
}
