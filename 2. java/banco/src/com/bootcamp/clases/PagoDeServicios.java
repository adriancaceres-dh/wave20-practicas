package com.bootcamp.clases;

import com.bootcamp.interfaces.ITransaccion;

public class PagoDeServicios implements ITransaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Realizándose pago de servicio");
        System.out.println("Pago de servicios exitoso");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Error en pago de servicios");
    }
}
