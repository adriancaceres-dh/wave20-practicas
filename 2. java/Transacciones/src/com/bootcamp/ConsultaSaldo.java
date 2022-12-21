package com.bootcamp;

public class ConsultaSaldo implements Transaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Consultado saldo");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Error en la consulta de saldo");
    }
}
