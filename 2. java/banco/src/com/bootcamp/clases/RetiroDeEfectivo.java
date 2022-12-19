package com.bootcamp.clases;

import com.bootcamp.interfaces.ITransaccion;

public class RetiroDeEfectivo implements ITransaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Realizándose retiro de efectivo");
        System.out.println("Retiro de efectivo exitoso");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Error en retiro de efectivo");
    }
}
