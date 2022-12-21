package com.bootcamp;

public class Deposito implements iTransaccion{
    @Override
    public static void transaccionOk() {
        System.out.println("Se depositó dinero con éxito.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No se pudo depositar el dinero, vuelva a intentarlo más tarde.");
    }
}
