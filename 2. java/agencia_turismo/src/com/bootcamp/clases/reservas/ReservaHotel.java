package com.bootcamp.clases.reservas;

import java.util.Date;

public class ReservaHotel extends Reserva {
    private static double precioCatalogo = 20000;
    private static final String tipoReserva = "HOTEL";

    private String hotel;

    public ReservaHotel() {
        this.precio = precioCatalogo;
        this.tipo = tipoReserva;
    }

    public ReservaHotel(Date fecha, String hotel) {
        super(fecha);
        this.hotel = hotel;
        this.precio = precioCatalogo;
        this.tipo = tipoReserva;
    }

    public static double getPrecioCatalogo() {
        return precioCatalogo;
    }

    public static void setPrecioCatalogo(double precioCatalogo) {
        ReservaHotel.precioCatalogo = precioCatalogo;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public static String getTipoReserva() {
        return tipoReserva;
    }

    @Override
    public String toString() {
        return "ReservaHotel{" +
                "precio=" + precio +
                ", fecha=" + fecha +
                ", restaurante='" + hotel + '\'' +
                '}';
    }
}
