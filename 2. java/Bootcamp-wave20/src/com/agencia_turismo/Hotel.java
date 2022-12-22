package com.agencia_turismo;

public class Hotel implements Reserva{

    private Double precio;

    public Hotel(Double precio) {
        this.precio = precio;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
