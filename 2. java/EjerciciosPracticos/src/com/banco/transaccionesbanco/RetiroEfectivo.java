package com.banco.transaccionesbanco;

public class RetiroEfectivo implements Transacciones{
    @Override
    public String transaccionOK() {
        return "Retiro exitoso!";
    }

    @Override
    public String transaccionNoOk() {
        return "Retiro fallido!";
    }
}
