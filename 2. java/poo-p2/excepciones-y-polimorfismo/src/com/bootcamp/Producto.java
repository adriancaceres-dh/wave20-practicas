package com.bootcamp;

public class Producto {
    String nombre;
    double precio;

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

    public Producto (String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    public String toString() {
        String salida = "";
        salida += "Nombre:" + this.nombre + "\n";
        salida += "Precio:" + this.precio + "\n";
        return salida;
    }

    public double calcular (int cantidadDeProductos) {
        return Math.round(this.precio * cantidadDeProductos);
    }
}
