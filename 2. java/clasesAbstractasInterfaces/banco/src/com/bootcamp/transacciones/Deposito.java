package com.bootcamp.transacciones;

public interface Deposito implements Transaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Realizando transaccion ...");
        System.out.println("Transaccion ok");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transaccion NO relaizada ...");
        System.out.println("Transaccion NO ok");
    }


}
