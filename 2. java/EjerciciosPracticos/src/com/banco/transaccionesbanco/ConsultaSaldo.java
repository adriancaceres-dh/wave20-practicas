package com.banco.transaccionesbanco;

public class ConsultaSaldo implements Transacciones{
    @Override
    public String transaccionOK() {
        return "Consultando saldo exitosamente!";
    }

    @Override
    public String transaccionNoOk() {
        return "No se puede consultar saldo!!";
    }
}
