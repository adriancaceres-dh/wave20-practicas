package com.bootcamp;

import com.bootcamp.productos.Producto;

import java.util.List;

public class Localizador {
    private Cliente cliente;
    private List<Producto> reserva;
    private double total;

    public Localizador(Cliente cliente, List<Producto> reserva) {
        this.cliente = cliente;
        this.reserva = reserva;
        total = 0;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Producto> getReserva() {
        return reserva;
    }

    public void setReserva(List<Producto> reserva) {
        this.reserva = reserva;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Localizador{" +
                "cliente=" + cliente +
                ", reserva=" + reserva +
                ", total=" + total +
                '}';
    }
}
