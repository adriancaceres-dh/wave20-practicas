package com.bootcamp;

public class Deposito implements ITransaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Depósito exitoso");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Depósito no realizado");
    }
}
