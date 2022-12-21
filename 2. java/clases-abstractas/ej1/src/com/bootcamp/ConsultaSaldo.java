package com.bootcamp;

public class ConsultaSaldo implements iTransaccion{
    @Override
    public static void transaccionOk() {
        System.out.println("El saldo de su cuenta es mucho.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No se pudo consultar el saldo, vuelva a intentarlo más tarde.");
    }
}
