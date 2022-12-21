package com.bootcamp.reserva;

import java.time.LocalDate;

public class Reserva {
    private String id;
    private TipoReserva tipo;
    private double costo;

    public Reserva(String id, TipoReserva tipo, double costo) {
        this.id = id;
        this.tipo = tipo;
        this.costo = costo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TipoReserva getTipo() {
        return tipo;
    }

    public void setTipo(TipoReserva tipo) {
        this.tipo = tipo;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        return String.format("%-15s ............... $ %8.2f", tipo.toString(), costo);
    }
}
