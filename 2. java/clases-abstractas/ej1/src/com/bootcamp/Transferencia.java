package com.bootcamp;

public class Transferencia implements iTransaccion{
    @Override
    public static void transaccionOk() {
        System.out.println("Se transfirió dinero con éxito.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No se pudo transferir dinero, vuelva a intentarlo más tarde.");
    }
}
