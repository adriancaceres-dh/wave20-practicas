package com.transacciones_banco;

public class Basico implements ICliente{
    private String nombre;

    public Basico(String nombre) {
        this.nombre = nombre;
    }
    @Override
    public String getNombre() {
        return nombre;
    }
}
