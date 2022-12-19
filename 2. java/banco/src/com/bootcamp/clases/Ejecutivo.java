package com.bootcamp.clases;

public class Ejecutivo extends Cliente {
    public void realizarDeposito(double monto) {
        if(monto > 0.0) realizarTransaccion(new Deposito());
        else            realizarTransaccionErronea(new Deposito());
    }

    public void realizarTransferencia(double monto) {
        if(monto > 0.0) realizarTransaccion(new Transferencia());
        else            realizarTransaccionErronea(new Transferencia());
    }
}
