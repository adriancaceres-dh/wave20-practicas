package com.bootcamp.clases;

import java.time.LocalDate;

public class Reserva {

    double precio;
    LocalDate fecha;

    public Reserva(double precio, LocalDate fecha) {
        this.precio = precio;
        this.fecha = fecha;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "precio=" + precio +
                ", fecha=" + fecha +
                '}';
    }
}
