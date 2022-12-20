package com.bootcamp.clases.reservas;

import java.util.Date;

public class ReservaComida extends Reserva {
    private static double precioCatalogo = 1000;
    private static final String tipoReserva = "COMIDA";

    private String restaurante;

    public ReservaComida() {
        this.precio = precioCatalogo;
        this.tipo = tipoReserva;
    }

    public ReservaComida(Date fecha, String restaurante) {
        super(fecha);
        this.restaurante = restaurante;
        this.precio = precioCatalogo;
        this.tipo = tipoReserva;
    }

    public static double getPrecioCatalogo() {
        return precioCatalogo;
    }

    public static void setPrecioCatalogo(double precioCatalogo) {
        ReservaComida.precioCatalogo = precioCatalogo;
    }

    public String getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(String restaurante) {
        this.restaurante = restaurante;
    }

    public static String getTipoReserva() {
        return tipoReserva;
    }

    @Override
    public String toString() {
        return "ReservaComida{" +
                "precio=" + precio +
                ", fecha=" + fecha +
                ", restaurante='" + restaurante + '\'' +
                '}';
    }
}
