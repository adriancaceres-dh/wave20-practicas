package com.transacciones_banco;

public class Cobrador implements ICliente {
    private String nombre;

    public Cobrador(String nombre) {
        this.nombre = nombre;
    }
    @Override
    public String getNombre() {
        return nombre;
    }

}
