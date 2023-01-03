package com.bootcamp;

import java.util.List;
import java.util.stream.Collectors;

// Reservas: Hotel, comida, boletos de viaje, transporte.

public class Localizador {
    Cliente cliente;
    double total;
    List<List<Integer>> reservas; // [[4500, 2000], [], [300, 150], [200]] -> [4500, 2000, 300, 150, 200]

    public Localizador(Cliente cliente, List<List<Integer>> reservas) {
        this.cliente = cliente;
        this.reservas = reservas;
        this.total = this.aplicarDescuentos();
    }

    boolean tieneDescuentoPaquete() {
        boolean esCompleto = true;
        for(List<Integer> reserva : reservas) {
            esCompleto = esCompleto && !reserva.isEmpty();
        }
        return esCompleto;
    }

    boolean tieneDescuentoFuturo() {
        return cliente.localizadoresContratados.size() >= 2;
    }

    double aplicarDescuentos () {
        double total = 0;
        // Si tiene descuentos que se apliquen al paquete completo.
        if (tieneDescuentoPaquete()) {
            total = reservas.stream().flatMap(List::stream).collect(Collectors.toList()).stream().mapToInt(Integer::intValue).sum() * 0.9;
        } else if (tieneDescuentoFuturo()) {
            total = reservas.stream().flatMap(List::stream).collect(Collectors.toList()).stream().mapToInt(Integer::intValue).sum() * 0.95;
        // En caso que haya descuentos para ciertas reservas, o ningún descuento.
        } else {
            for (int i = 0; i < reservas.size(); i++) {
                // Si tiene descuento en Hoteles o Viajes.
                if((i == 0 || i == 2) && reservas.get(i).size() >= 2) {
                    total += reservas.get(i).stream().mapToInt(Integer::intValue).sum() * 0.95;
                } else {
                    total += reservas.get(i).stream().mapToInt(Integer::intValue).sum();
                }
            }
        }
        return total;
    }

    @Override
    public String toString() {
        return "Localizador:" +
                "Cliente=" + cliente +
                ", Total=" + total +
                ", Reservas=" + reservas;
    }
}
