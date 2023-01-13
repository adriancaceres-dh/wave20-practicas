package com.productos.models;

public class ProductosNoPerecederos extends Productos{

    private String tipo;

    public ProductosNoPerecederos(String nombre, Double precio) {
        super(nombre, precio);
    }

    public ProductosNoPerecederos() {

    }

    public String getTipo() {
        return tipo;
    }


    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return super.toString() +
                "ProductosNoPerecederos{" +
                "tipo='" + tipo + '\'' +
                '}';
    }
}
