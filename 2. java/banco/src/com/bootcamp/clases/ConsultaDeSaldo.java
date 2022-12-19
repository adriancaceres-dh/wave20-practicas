package com.bootcamp.clases;

import com.bootcamp.interfaces.ITransaccion;

public class ConsultaDeSaldo implements ITransaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Realizando consulta de saldo");
        System.out.println("Consulta de saldo exitosa");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Error en consulta de saldo");
    }
}
