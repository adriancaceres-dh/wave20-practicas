package com.bootcamp;

public class Transferencia implements ITransaccion{
    @Override
    public void transaccionNoOk() {
        System.out.println("Transferencia exitosa");
    }

    @Override
    public void transaccionOk() {
        System.out.println("Transferencia no realizada");
    }
}
