package com.bootcamp.operaciones;

public class Deposito implements TransaccionInterface {

    public void realizarDeposito(int cantidadADepositar) {
        if (cantidadADepositar <= 0) {
            transaccionNoOk();
        } else {
            transaccionOk();
        }
    }

    @Override
    public void transaccionOk() {
        System.out.println("El depósito fue exitoso");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("El depósito no se pudo realizar");
    }
}
