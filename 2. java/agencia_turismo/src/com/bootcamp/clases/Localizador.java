package com.bootcamp.clases;

import com.bootcamp.clases.reservas.Reserva;

import java.util.ArrayList;
import java.util.List;

public class Localizador {
    private final Cliente cliente;
    private List<Reserva> reservas;
    private final double precioTotal;   // Sin descuento
    private final double precioFinal;   // Con descuento

    public Localizador(Cliente cliente, List<Reserva> reservas, double precioTotal, double precioFinal) {
        this.cliente = cliente;
        this.reservas = reservas;
        this.precioTotal = precioTotal;
        this.precioFinal = precioFinal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public double getPrecioFinal() {
        return precioFinal;
    }

    @Override
    public String toString() {
        return "Localizador{" +
                "cliente=" + cliente +
                ", reservas=" + reservas +
                ", precioTotal=" + precioTotal +
                ", precioFinal=" + precioFinal +
                '}';
    }
}
