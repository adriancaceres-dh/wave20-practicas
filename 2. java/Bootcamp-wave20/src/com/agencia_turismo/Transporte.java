package com.agencia_turismo;

public class Transporte implements Reserva{

    private Double precio;

    public Transporte(Double precio) {
        this.precio = precio;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
