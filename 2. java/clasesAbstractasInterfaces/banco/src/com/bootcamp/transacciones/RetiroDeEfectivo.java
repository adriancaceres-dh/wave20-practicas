package com.bootcamp.transacciones;

public class RetiroDeEfectivo implements Transaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Realizando retiro efectivo ...");
        System.out.println("Transaccion ok");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Retiro efectivo NO relaizado ...");
        System.out.println("Transaccion NO ok");

    }
}
