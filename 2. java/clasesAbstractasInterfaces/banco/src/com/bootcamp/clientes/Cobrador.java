package com.bootcamp.clientes;

import com.bootcamp.transacciones.IConsultaDeSaldo;
import com.bootcamp.transacciones.IRetiroDeEfectivo;

public class Cobrador extends Cliente implements IRetiroDeEfectivo, IConsultaDeSaldo {

    public Cobrador(int id, String nombre) {
        super(id, nombre);
    }

    @Override
    public void realizarConsultaSaldo() {
        System.out.println("Cliente: " + super.getNombre() + "\nRealizando consulta de saldo...");
    }

    @Override
    public void realizarRetiroEfectivo() {
        System.out.println("Cliente: " + super.getNombre() + "\nRealizando retiro de efectivo...");
    }

    @Override
    public void transaccionOk() {
        System.out.println("Transaccion realizada con exito!");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transaccion realizada sin exito");
    }
}
