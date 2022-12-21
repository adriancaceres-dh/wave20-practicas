package com.bootcamp;

public class Retiro implements iTransaccion {
    @Override
    public static void transaccionOk() {
        System.out.println("Se retiró dinero con éxito.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No se pudo retirar dinero, vuelva a intentarlo más tarde.");
    }
}
