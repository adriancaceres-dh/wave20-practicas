package com.agencia_turismo;

public class Comida implements Reserva{
    private Double precioUnitario;

    public Comida(Double precio) {
        this.precioUnitario = precio;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
}
