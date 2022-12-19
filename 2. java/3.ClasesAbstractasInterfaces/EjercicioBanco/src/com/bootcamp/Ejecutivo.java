package com.bootcamp;

import com.bootcamp.interfaces.Deposito;
import com.bootcamp.interfaces.Transferencia;

public class Ejecutivo implements Transferencia, Deposito {

    @Override
    public void realizarTransferencia() {
        System.out.println("Realizando Transferencia");
    }

    @Override
    public void realizarDeposito() {
        System.out.println("Realizando depósito");
    }

    @Override
    public void transaccionOk(String transaccion) {
        System.out.println("Transacción "+transaccion+" realizada con éxito");
    }
    @Override
    public void transaccionNoOk(String transaccion) {
        System.out.println("Transacción "+transaccion+" intentada sin éxito");
    }
}
