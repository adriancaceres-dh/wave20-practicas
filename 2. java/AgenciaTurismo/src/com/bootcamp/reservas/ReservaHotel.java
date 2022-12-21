package com.bootcamp.reservas;

public class ReservaHotel extends Reserva {
    private String nombreHotel;

    public ReservaHotel(String codigo, double precio, int cantidad, String nombreHotel) {
        super(codigo, precio, cantidad);
        this.nombreHotel = nombreHotel;
    }

    @Override
    public String toString() {
        return "ReservaHotel{" +
                "nombreHotel='" + nombreHotel + '\'' +
                "} " + super.toString();
    }
}
