package com.bootcamp;

public class RetiroEfectivo implements ITransaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Realizando retiro en efectivo");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Error en el retiro en efectivo");
    }
}
