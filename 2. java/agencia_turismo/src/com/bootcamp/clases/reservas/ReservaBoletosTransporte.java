package com.bootcamp.clases.reservas;

import java.util.Date;

public class ReservaBoletosTransporte extends Reserva {
    private static double precioCatalogo = 1600;
    private static final String tipoReserva = "TRANSPORTE";

    private String medioTransporte;

    public ReservaBoletosTransporte() {
        this.precio = precioCatalogo;
        this.tipo = tipoReserva;
    }

    public ReservaBoletosTransporte(Date fecha, String medioTransporte) {
        super(fecha);
        this.medioTransporte = medioTransporte;
        this.precio = precioCatalogo;
        this.tipo = tipoReserva;
    }

    public static double getPrecioCatalogo() {
        return precioCatalogo;
    }

    public static void setPrecioCatalogo(double precioCatalogo) {
        ReservaBoletosTransporte.precioCatalogo = precioCatalogo;
    }

    public String getMedioTransporte() {
        return medioTransporte;
    }

    public void setMedioTransporte(String medioTransporte) {
        this.medioTransporte = medioTransporte;
    }

    public static String getTipoReserva() {
        return tipoReserva;
    }

    @Override
    public String toString() {
        return "ReservaBoletosTransporte{" +
                "precio=" + precio +
                ", fecha=" + fecha +
                ", medioTransporte='" + medioTransporte + '\'' +
                '}';
    }
}
