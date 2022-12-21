package Clases;

import java.util.Collection;
import java.util.List;

public class Localizador {
    private Cliente cliente;
    private double total;
    private List<Reserva> reservas;

    public Localizador(Cliente cliente, double total, List<Reserva> reservas) {
        this.cliente = cliente;
        this.total = total;
        this.reservas = reservas;
    }

    @Override
    public String toString() {
        return "Localizador{" +
                "cliente=" + cliente +
                ", total=" + total +
                ", reservas=" + reservas +
                '}';
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public double getTotal() {
        return total;
    }
}
