package com.bootcamp.clases.reservas;

import java.util.Date;

public abstract class Reserva {
    protected String tipo;
    protected double precio;
    protected Date fecha;

    public Reserva() {

    }

    public Reserva(Date fecha) {
        this.fecha = fecha;
    }

    public Reserva(Date fecha, double precio, String tipo) {
        this.fecha = fecha;
        this.precio = precio;
        this.tipo = tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
