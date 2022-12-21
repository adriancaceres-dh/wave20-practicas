package com.bootcamp;

public class Deposito implements Transaccion{

    @Override
    public void transaccionOk() {
        System.out.println("Realizando deposito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Error durante el deposito");
    }
}
