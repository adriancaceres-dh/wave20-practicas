package com.bootcamp.clases.reservas;

import java.util.Date;

public class ReservaBoletosViaje extends Reserva {
    private static double precioCatalogo = 10000;
    private static final String tipoReserva = "VIAJE";

    private String destino;

    public ReservaBoletosViaje() {
        this.precio = precioCatalogo;
        this.tipo = tipoReserva;
    }

    public ReservaBoletosViaje(Date fecha, String destino) {
        super(fecha);
        this.destino = destino;
        this.precio = precioCatalogo;
        this.tipo = tipoReserva;
    }

    public static double getPrecioCatalogo() {
        return precioCatalogo;
    }

    public static void setPrecioCatalogo(double precioCatalogo) {
        ReservaBoletosViaje.precioCatalogo = precioCatalogo;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public static String getTipoReserva() {
        return tipoReserva;
    }

    @Override
    public String toString() {
        return "ReservaBoletosViaje{" +
                "precio=" + precio +
                ", fecha=" + fecha +
                ", destino='" + destino + '\'' +
                '}';
    }
}
