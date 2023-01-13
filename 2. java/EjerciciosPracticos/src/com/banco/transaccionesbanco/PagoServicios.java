package com.banco.transaccionesbanco;

public class PagoServicios implements Transacciones{
    @Override
    public String transaccionOK() {
        return "Pago exitoso!";
    }

    @Override
    public String transaccionNoOk() {
        return "Pago fallido!";
    }
}
