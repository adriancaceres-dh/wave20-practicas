package com.bootcamp.productos;

public class Comida extends Producto{
    boolean vegana;

    public Comida(double precio, boolean vegana) {
        super(precio);
        this.vegana = vegana;
    }

    public boolean isVegana() {
        return vegana;
    }

    public void setVegana(boolean vegana) {
        this.vegana = vegana;
    }
}
