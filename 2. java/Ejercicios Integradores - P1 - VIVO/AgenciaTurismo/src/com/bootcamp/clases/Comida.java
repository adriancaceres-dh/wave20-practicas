package com.bootcamp.clases;

import java.time.LocalDate;

public class Comida extends Reserva{

    String tipoComida;

    public Comida(double precio, LocalDate fecha, String tipoComida) {
        super(precio, fecha);
        this.tipoComida = tipoComida;
    }

    @Override
    public String toString() {
        return "Comida{" +
                "precio=" + precio +
                ", fecha=" + fecha +
                ", tipoComida='" + tipoComida + '\'' +
                '}';
    }
}
