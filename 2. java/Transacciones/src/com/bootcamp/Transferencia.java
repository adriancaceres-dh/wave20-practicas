package com.bootcamp;

public class Transferencia implements ITransaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Realizando transferencia");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Error en la transferencia");
    }
}
