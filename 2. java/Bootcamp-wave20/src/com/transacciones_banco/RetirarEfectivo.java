package com.transacciones_banco;

public class RetirarEfectivo implements ITransaccion{

    @Override
    public void transaccionOk(ICliente cliente) {
        if (cliente instanceof Basico || cliente instanceof Cobrador) {
            System.out.println("Transaccion exitosa");

        } else {
            transaccionNoOk();
        }
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transaccion no permitida");

    }

    @Override
    public void aceptar(TransactionVisitor visitor) {
        visitor.visitar(this);
    }

}
