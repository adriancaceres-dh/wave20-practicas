package com.bootcamp;

public class Producto {
    private String nombre;
    private double precio;

    public double getPrecio() {
        return precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public double calcular(int cantidadDeProductos) {
        return this.precio * cantidadDeProductos;
    }

    @Override
    public String toString() {
        return "Nombre: " + this.nombre + ". Precio: " + this.precio;
    }
}
