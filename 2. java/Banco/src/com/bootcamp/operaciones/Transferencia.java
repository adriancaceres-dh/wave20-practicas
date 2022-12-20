package com.bootcamp.operaciones;

public class Transferencia implements TransaccionInterface {

    public void realizarTransferencia(int cantidadATransferir) {
        if (cantidadATransferir <= 0) {
            transaccionNoOk();
        } else {
            transaccionOk();
        }
    }

    @Override
    public void transaccionOk() {
        System.out.println("La transferencia fue exitosa");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("La transferencia no fue exitosa");
    }
}
