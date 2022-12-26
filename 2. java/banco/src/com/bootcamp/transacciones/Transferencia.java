package com.bootcamp.transacciones;

public class Transferencia implements ITransaccion{

    public void realizarTransferencia(boolean ok) {
        if (ok) {
            transaccionOk();
        }
        else {
            transaccionNotOk();
        }
    }
    @Override
    public void transaccionOk() {
        System.out.println("Transferencia realizada");
    }

    @Override
    public void transaccionNotOk() {
        System.out.println("Transferencia no realizada");
    }
}
