package com.bootcamp;

import com.bootcamp.reservas.Reserva;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Localizador {
    private Cliente cliente;
    private double totalReserva;
    private double totalACobrar;
    private List<Reserva> reservas;

    public Localizador(Cliente cliente) {
        this.cliente = cliente;
        this.totalReserva = 0;
        this.totalACobrar = 0;
        this.reservas = new ArrayList<>();
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void addReserva(Reserva reserva) {
        reservas.add(reserva);
        calcularTotalReserva();
    }

    private void calcularTotalReserva() {
        totalReserva = reservas.stream()
                .mapToDouble(Reserva::getPrecioTotal)
                .sum();
        totalACobrar = totalReserva;
    }


    public void aplicarDescuento(int descuento) {
        totalACobrar = totalReserva * ((100d - descuento) / 100);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getTotalACobrar() {
        return totalACobrar;
    }

    public double getTotalReserva() {
        return totalReserva;
    }

    @Override
    public String toString() {
        return "Localizador{" +
                "cliente=" + cliente +
                ", totalReserva=" + totalReserva +
                ", totalACobrar=" + totalACobrar +
                ", reservas=" + reservas +
                '}';
    }
}
