package com.bootcamp.clientes;

import com.bootcamp.operaciones.ConsultaSaldo;
import com.bootcamp.operaciones.RetiroEfectivo;

public class Cobrador {
    private final RetiroEfectivo retiroEfectivo;
    private final ConsultaSaldo consultaSaldo;

    public Cobrador() {
        retiroEfectivo = new RetiroEfectivo();
        consultaSaldo = new ConsultaSaldo();
    }

    public void consultarSaldo(int numeroCuenta) {
        consultaSaldo.consultarSaldo(numeroCuenta);
    }

    public void retirarEfectivo(int cantidad) {
        retiroEfectivo.retirar(cantidad);
    }
}
