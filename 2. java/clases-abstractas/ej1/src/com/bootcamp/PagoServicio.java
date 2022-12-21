package com.bootcamp;

public class PagoServicio implements iTransaccion{
    @Override
    public static void transaccionOk() {
        System.out.println("Se pagó el servicio con éxito.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No se pudo pagar el servicio, vuelva a intentarlo más tarde.");
    }
}
