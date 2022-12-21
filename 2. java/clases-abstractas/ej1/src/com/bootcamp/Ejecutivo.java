package com.bootcamp;

public class Ejecutivo extends Cliente {

    public void realizarDeposito() {
        realizarTransaccion(1);
    }

    public void realizarTransferencia() {
        realizarTransaccion(2);
    }
}
