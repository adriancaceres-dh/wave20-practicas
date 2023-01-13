package com.productos.models;

public class Productos {

    private String nombre;
    private Double precio;

    public Productos(String nombre, Double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public Productos() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }


    public int calcular(int cantidadDeProductos){

        int calcularPrecioFinal = precio.intValue()*(cantidadDeProductos);

        return calcularPrecioFinal;
    }


    @Override
    public String toString() {
        return "Productos{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }
}
