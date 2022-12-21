package com.bootcamp.localizador;

import com.bootcamp.Cliente;
import com.bootcamp.reserva.Reserva;
import com.bootcamp.descuento.IDescuento;
import com.bootcamp.descuento.ListaDescuentos;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class Localizador {
    private static long count = 1;
    private long id;
    private LocalDate fecha;
    private Cliente cliente;
    private List<Reserva> reservas;
    private ListaDescuentos descuentos;

    protected Localizador(LocalDate fecha, Cliente cliente, List<Reserva> reservas) {
        id = count++;
        this.fecha = fecha;
        this.cliente = cliente;
        this.reservas = reservas;
        this.descuentos = new ListaDescuentos(this);
    }

    public long getId() { return id;}

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
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

    public double importeFinal() {
        return subTotal() - descuentosAplicados().stream().mapToDouble(d -> d.aplicarDescuento()).sum();
    }

    public List<IDescuento> descuentosAplicados() {
        return descuentos.getDescuentos().stream()
                .filter(d -> d.aplicarDescuento() > 0)
                .collect(Collectors.toList());
    }

    public double subTotal() {
        return reservas.stream().mapToDouble(r -> r.getCosto()).sum();
    }
}
