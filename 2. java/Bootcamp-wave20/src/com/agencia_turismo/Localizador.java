package com.agencia_turismo;

import java.util.List;

public class Localizador {

    private Cliente cliente;
    private List<Reserva> reservas;
    private Double total;

    public Localizador(Cliente cliente, List<Reserva> reservas, Double total) {
        this.cliente = cliente;
        this.reservas = reservas;
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Localizador{" +
                "cliente=" + cliente +
                ", reservas=" + reservas +
                ", total=" + total +
                '}';
    }
}
