package com.bootcamp.reservas;

public class Transporte extends Reserva {
    private String nombreChofer;
    private String tipo;

    public Transporte(String codigo, double precio, int cantidad, String nombreChofer, String tipo) {
        super(codigo, precio, cantidad);
        this.nombreChofer = nombreChofer;
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Transporte{" +
                "nombreChofer='" + nombreChofer + '\'' +
                ", tipo='" + tipo + '\'' +
                "} " + super.toString();
    }
}
