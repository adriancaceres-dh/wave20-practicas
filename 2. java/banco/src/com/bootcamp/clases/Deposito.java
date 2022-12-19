package com.bootcamp.clases;

import com.bootcamp.interfaces.ITransaccion;

public class Deposito implements ITransaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Realizándose depósito");
        System.out.println("Deposito exitoso");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Error en depósito");
    }
}
