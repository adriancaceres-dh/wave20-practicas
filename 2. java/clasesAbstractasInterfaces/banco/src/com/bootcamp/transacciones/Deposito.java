package com.bootcamp.clases;

import java.sql.SQLOutput;

public class Deposito implements Transaccion {

    @Override
    public void transaccionOk() {
        System.out.println("Realizando deposito ...");
        System.out.println("Transaccion ok");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Deposito NO relaizado ...");
        System.out.println("Transaccion NO ok");
    }
}
