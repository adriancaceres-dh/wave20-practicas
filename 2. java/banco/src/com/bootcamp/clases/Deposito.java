package com.bootcamp.clases;

import com.bootcamp.interfaces.ITransaccion;

public class Deposito implements ITransaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Realizando depósito");
        System.out.println("Depósito exitoso");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Error en depósito");
    }
}
