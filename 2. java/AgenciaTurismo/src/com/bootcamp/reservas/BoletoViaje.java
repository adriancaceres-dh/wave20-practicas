package com.bootcamp.reservas;

public class BoletoViaje extends Reserva {
    private String nombreOrigen;
    private String nombreDestino;

    public BoletoViaje(String codigo, double precio, int cantidad, String nombreOrigen, String nombreDestino) {
        super(codigo, precio, cantidad);
        this.nombreOrigen = nombreOrigen;
        this.nombreDestino = nombreDestino;
    }

    @Override
    public String toString() {
        return "BoletoViaje{" +
                "nombreOrigen='" + nombreOrigen + '\'' +
                ", nombreDestino='" + nombreDestino + '\'' +
                "} " + super.toString();
    }
}
