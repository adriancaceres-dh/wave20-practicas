package com.bootcamp.clases.reservas;

import java.util.Date;

public class ReservaHotel extends Reserva {
    private static double precioCatalogo = 20000;
    private static final String tipoReserva = "HOTEL";

    private String restaurante;

    public ReservaHotel() {
        this.precio = precioCatalogo;
        this.tipo = tipoReserva;
    }

    public ReservaHotel(Date fecha, String restaurante) {
        super(fecha);
        this.restaurante = restaurante;
        this.precio = precioCatalogo;
        this.tipo = tipoReserva;
    }

    public static double getPrecioCatalogo() {
        return precioCatalogo;
    }

    public static void setPrecioCatalogo(double precioCatalogo) {
        ReservaHotel.precioCatalogo = precioCatalogo;
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
        return "ReservaHotel{" +
                "precio=" + precio +
                ", fecha=" + fecha +
                ", restaurante='" + restaurante + '\'' +
                '}';
    }
}
