package com.transacciones_banco;

public class ConsultarSaldo implements ITransaccion {


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
        System.out.println("La transaccion no esta permitida");


    }

    @Override
    public void aceptar(TransactionVisitor visitor) {
        visitor.visitar(this);
    }


}
