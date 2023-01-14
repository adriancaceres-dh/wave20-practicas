package com.banco.transaccionesbanco;

public class Transferencia implements Transacciones{


    @Override
    public String transaccionOK() {
        return "Transferencia exitosa";
    }

    @Override
    public String transaccionNoOk() {
        return "Transferencia fallida!";
    }
}
