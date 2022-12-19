package com.bootcamp.clases;

import com.bootcamp.interfaces.ITransaccion;

public class Transferencia implements ITransaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Realizándose transferencia");
        System.out.println("Transferencia exitosa");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Error en transferencia");
    }
}
