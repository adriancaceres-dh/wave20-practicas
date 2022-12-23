package com.bootcamp.transacciones;

public class ConsultaDeSaldo implements Transaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Realizando consulta de saldo ...");
        System.out.println("Transaccion ok");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Consulta de saldo NO relaizado ...");
        System.out.println("Transaccion NO ok");

    }
}
