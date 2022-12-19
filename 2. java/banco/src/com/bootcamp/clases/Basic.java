package com.bootcamp.clases;

public class Basic extends Cobrador {
    public void realizarPagoDeServicios(double monto) {
        if(monto > 0.0) realizarTransaccion(new PagoDeServicios());
        else            realizarTransaccionErronea(new PagoDeServicios());
    }
}
