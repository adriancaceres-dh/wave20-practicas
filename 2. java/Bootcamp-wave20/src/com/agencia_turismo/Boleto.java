package com.agencia_turismo;

public class Boleto implements Reserva {

    private Double precio;

    public Boleto(Double precio) {
        this.precio = precio;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
