package com.bootcamp;

public class PagoDeServicios implements ITransaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Realizando pago de servicios");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Error en el pago de servicios");
    }
}
