package com.bootcamp;

public class ConsultaSaldo implements ITransaccion{
    @Override
    public void transaccionNoOk() {
        System.out.println("Los datos no son correctos");
    }

    @Override
    public void transaccionOk() {
        System.out.println("Su saldo es de _____$");
    }
}
