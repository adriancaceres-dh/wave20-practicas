package com.bootcamp.transacciones;

public class ConsultaSaldo implements ITransaccion{

    public void realizarConsultaDeSaldo(boolean ok) {
        if (ok) {
            transaccionOk();
        }
        else {
            transaccionNotOk();
        }
    }

    @Override
    public void transaccionOk() {
        System.out.println("Su saldo es... ");
    }

    @Override
    public void transaccionNotOk() {
        System.out.println("No se pudo realizar la consulta de saldo");
    }
}
