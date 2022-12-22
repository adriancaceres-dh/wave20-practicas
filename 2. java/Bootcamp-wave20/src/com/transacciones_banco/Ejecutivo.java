package com.transacciones_banco;

public class Ejecutivo implements ICliente {
    private String nombre;

    public Ejecutivo(String nombre) {
        this.nombre = nombre;
    }
    @Override
    public String getNombre() {
        return nombre;
    }
}
