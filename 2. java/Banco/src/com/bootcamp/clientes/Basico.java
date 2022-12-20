package com.bootcamp.clientes;

import com.bootcamp.operaciones.ConsultaSaldo;
import com.bootcamp.operaciones.PagoServicio;
import com.bootcamp.operaciones.RetiroEfectivo;

public class Basico {
    private final ConsultaSaldo consultaSaldo;
    private final PagoServicio pagoServicio;
    private final RetiroEfectivo retiroEfectivo;

    public Basico() {
        consultaSaldo = new ConsultaSaldo();
        pagoServicio = new PagoServicio();
        retiroEfectivo = new RetiroEfectivo();
    }

    public void pagarServicio(String nombreServicio) {
        pagoServicio.pagar(nombreServicio);
    }

    public void consultarSaldo(int numeroCuenta) {
        consultaSaldo.consultarSaldo(numeroCuenta);
    }

    public void retirarEfectivo(int cantidad) {
        retiroEfectivo.retirar(cantidad);
    }

}
