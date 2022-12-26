package com.bootcamp.clientes;

import com.bootcamp.transacciones.Deposito;
import com.bootcamp.transacciones.Transferencia;

public class Ejecutivo {
    Deposito servicioDeposito;
    Transferencia servicioTransferencia;

    public Ejecutivo() {
        this.servicioDeposito = new Deposito();
        this.servicioTransferencia = new Transferencia();
    }

    public Deposito getServicioDeposito() {
        return servicioDeposito;
    }

    public void setServicioDeposito(Deposito servicioDeposito) {
        this.servicioDeposito = servicioDeposito;
    }

    public Transferencia getServicioTransferencia() {
        return servicioTransferencia;
    }

    public void setServicioTransferencia(Transferencia servicioTransferencia) {
        this.servicioTransferencia = servicioTransferencia;
    }

    @Override
    public String toString() {
        return "Ejecutivo{" +
                "servicioDeposito=" + servicioDeposito +
                ", servicioTransferencia=" + servicioTransferencia +
                '}';
    }
}
