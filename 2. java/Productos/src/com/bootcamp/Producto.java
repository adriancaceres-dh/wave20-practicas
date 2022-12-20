package com.bootcamp;

public class Producto {
    protected String nombre;
    protected double precio;

    public String getNombre() {
        return nombre;
    }
    public double getPrecio() {
        return precio;
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

    public double calcular(int cantidad){
        return cantidad*this.precio;
    }

    @Override
    public String toString() {
        return "com.bootcamp.Producto{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }
}
