package com.bootcamp;

public class Producto {
    private String nombre;
    private double precio;

    public Producto (String nombre, double precio){
        this.precio = precio;
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString(){
        return "Producto: "+this.nombre+", precio: $"+this.precio;
    }
    public double calcular (int cantidadDeProductos){
        return Math.round(cantidadDeProductos*this.precio);
    }
}
