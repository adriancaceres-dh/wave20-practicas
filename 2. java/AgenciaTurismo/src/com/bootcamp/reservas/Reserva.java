package com.bootcamp.reservas;

public abstract class Reserva {
    private String codigo;
    private double precio;
    private int cantidad;

    public Reserva(String codigo, double precio, int cantidad) {
        this.codigo = codigo;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public double getPrecioTotal() {
        return precio * cantidad;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "codigo='" + codigo + '\'' +
                ", precio=" + precio +
                ", cantidad=" + cantidad +
                '}';
    }
}
