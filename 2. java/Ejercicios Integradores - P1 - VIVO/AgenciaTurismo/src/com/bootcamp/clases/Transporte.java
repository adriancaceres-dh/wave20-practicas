package com.bootcamp.clases;

import java.time.LocalDate;

public class Transporte extends Reserva{

    String tipoTransporte;


    public Transporte(double precio, LocalDate fecha, String tipoTransporte) {
        super(precio, fecha);
        this.tipoTransporte = tipoTransporte;
    }

    public String getTipoTransporte() {
        return tipoTransporte;
    }

    public void setTipoTransporte(String tipoTransporte) {
        this.tipoTransporte = tipoTransporte;
    }

    @Override
    public String toString() {
        return "Transporte{" +
                "precio=" + precio +
                ", fecha=" + fecha +
                ", tipoTransporte='" + tipoTransporte + '\'' +
                '}';
    }
}
