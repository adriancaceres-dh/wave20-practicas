package com.bootcamp.clientes;

import com.bootcamp.transacciones.IDeposito;
import com.bootcamp.transacciones.ITransferencia;

public class Ejecutivo extends Cliente implements IDeposito, ITransferencia {

    public Ejecutivo(int id, String nombre) {
        super(id, nombre);
    }

    @Override
    public void realizarDeposito() {
        System.out.println("Cliente: " + super.getNombre() + "\nRealizando deposito...");
    }

    @Override
    public void transaccionOk() {
        System.out.println("Transaccion realizada con exito!");

    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transaccion realizada sin exito");


    }

    @Override
    public void realizarTransferencia() {
        System.out.println("Cliente: " + super.getNombre() + "\nRealizando transferencia...");

    }
}
