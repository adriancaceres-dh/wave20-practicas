package com.bootcamp.clientes;

import com.bootcamp.operaciones.Deposito;
import com.bootcamp.operaciones.Transferencia;

public class Ejecutivo {
    private final Deposito deposito;
    private final Transferencia transferencia;

    public Ejecutivo() {
        deposito = new Deposito();
        transferencia = new Transferencia();
    }

    public void realizarDeposito(int cantidad) {
        deposito.realizarDeposito(cantidad);
    }

    public void realizarTransferencia(int cantidad) {
        transferencia.realizarTransferencia(cantidad);
    }

}
