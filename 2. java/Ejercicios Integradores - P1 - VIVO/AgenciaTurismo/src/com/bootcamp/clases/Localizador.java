package com.bootcamp.clases;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Localizador {

    Cliente cliente;
    double precioTotal;
    double descuentoToal;
    List<Reserva> reservas;

    public Localizador(Cliente cliente) {
        this.cliente = cliente;
        reservas = new ArrayList<>();
        this.precioTotal = 0;
        this.descuentoToal = 0;
    }

    public Localizador(Cliente cliente, List<Reserva> reservas) {
        this.cliente = cliente;
        this.reservas = reservas;
        this.precioTotal = 0;
        this.descuentoToal = 0;
    }

    public double getDescuentoToal() {
        return descuentoToal;
    }

    public void setDescuentoToal(double descuentoToal) {
        this.descuentoToal = descuentoToal;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public double calcularTotalReserva(List<Localizador> localizadoresAntiguos) {
        List<Reserva> reservasHotel = reservas.stream().filter(x -> x instanceof Hotel).collect(Collectors.toList());
        List<Reserva> reservasBoleto = reservas.stream().filter(x -> x instanceof BoletoViaje).collect(Collectors.toList());
        List<Reserva> reservasComida = reservas.stream().filter(x -> x instanceof Comida).collect(Collectors.toList());
        List<Reserva> reservasTransporte = reservas.stream().filter(x -> x instanceof Transporte).collect(Collectors.toList());
        double totalFactura = reservas.stream().mapToDouble(x -> x.getPrecio()).sum();
        List<Localizador> localizadoresFiltradosCliente = localizadoresAntiguos.stream().filter(x-> x.getCliente().getDni().equalsIgnoreCase(cliente.getDni())).collect(Collectors.toList());
        // Dado que puede tener varios descuentos a la misma vez, se verifican todos los posibles descuentos
        double descuento = 0;
        if (reservasHotel.size() >= 1 && reservasBoleto.size() >= 1 && reservasComida.size() >= 1 && reservasTransporte.size() >= 1) {
            descuento += totalFactura * 0.1;
        }
        if (reservasHotel.size() >= 2) {
            descuento += reservasHotel.stream().mapToDouble(x -> x.getPrecio()*0.05).sum();
        }
        if (reservasBoleto.size() >= 2) {
            descuento += reservasBoleto.stream().mapToDouble(x -> x.getPrecio()*0.05).sum();
        }
        if (localizadoresFiltradosCliente.size() >= 2){
            descuento += totalFactura * 0.05;
        }
        totalFactura -= descuento;
        setDescuentoToal(descuento);
        setPrecioTotal(totalFactura);
        return totalFactura;
    }

    @Override
    public String toString() {
        return "Localizador{" +
                "cliente=" + cliente +
                ", precioTotal=" + precioTotal +
                ", descuentoToal=" + descuentoToal +
                ", reservas=" + reservas +
                '}';
    }
}
