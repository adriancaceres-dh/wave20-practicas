package com.bootcamp.transacciones;

public class PagoServicios implements ITransaccion{

    public void realizarPagoServicios(boolean ok) {
        if (ok) {
            transaccionOk();
        }
        else {
            transaccionNotOk();
        }
    }
    @Override
    public void transaccionOk() {
        System.out.println("Servicios pagados");
    }

    @Override
    public void transaccionNotOk() {
        System.out.println("No se pudieron pagar los servicios");
    }
}
