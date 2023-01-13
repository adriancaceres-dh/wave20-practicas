package com.banco.transaccionesbanco;

public class Deposito implements Transacciones{
    @Override
    public String transaccionOK() {
        return "Deposito exitoso!";
    }

    @Override
    public String transaccionNoOk() {
        return "No se pudo depositar!";
    }
}
