package com.bootcamp;

public class Producto {
    private String codigo;
    private String nombre;
    private int cantidad;
    private long precioUnitario;

    public Producto(String codigo, String nombre, int cantidad, long precioUnitario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public long getTotal() {
        return precioUnitario * cantidad;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", cantidad=" + cantidad +
                ", precioUnitario=" + precioUnitario +
                '}';
    }
}
