package com.bootcamp;

public class Transferencia implements Transaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Realizando transferencia");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Error en la transferencia");
    }
}
