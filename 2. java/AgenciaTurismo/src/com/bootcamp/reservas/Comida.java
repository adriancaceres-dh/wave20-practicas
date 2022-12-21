package com.bootcamp.reservas;

public class Comida extends Reserva{
    private String nombreComida;
    private boolean esAptoVeganos;

    public Comida(String codigo, double precio, int cantidad, String nombreComida, boolean esAptoVeganos) {
        super(codigo, precio, cantidad);
        this.nombreComida = nombreComida;
        this.esAptoVeganos = esAptoVeganos;
    }

    @Override
    public String toString() {
        return "Comida{" +
                "nombreComida='" + nombreComida + '\'' +
                ", esAptoVeganos=" + esAptoVeganos +
                "} " + super.toString();
    }
}
