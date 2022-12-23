package com.bootcamp.clases;

public class PagoDeServicios implements Transaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Realizando pago de servicios ...");
        System.out.println("Transaccion ok");

    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Pago de servicios NO relaizado ...");
        System.out.println("Transaccion NO ok");
    }
}
