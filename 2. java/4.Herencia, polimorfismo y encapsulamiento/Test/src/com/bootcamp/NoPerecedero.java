package com.bootcamp;

public class NoPerecedero extends Producto {
    private final String tipo;

    public NoPerecedero(String nombre, double precio, String tipo) {
        super(nombre, precio);
        this.tipo = tipo;

    }

}
