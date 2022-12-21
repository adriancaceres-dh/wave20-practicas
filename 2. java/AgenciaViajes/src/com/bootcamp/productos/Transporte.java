package com.bootcamp.productos;

public class Transporte extends Producto{
    String compania;

    public Transporte(double precio, String compania) {
        super(precio);
        this.compania = compania;
    }

    public String getCompania() {
        return compania;
    }

    public void setCompania(String compania) {
        this.compania = compania;
    }
}
