package com.bootcamp;

import java.util.Collections;
import java.util.List;

// Reservas: Hotel, comida, boletos de viaje, transporte.

public class Localizador {
    Cliente cliente;
    double total;
    List<Integer> reservas; // [1, 2, 2, 3, 3, 3, 4, 3]
    List<Integer> precios;


    public Localizador(Cliente cliente, List<Integer> reservas, List<Integer> precios) {
        this.cliente = cliente;
        this.reservas = reservas;
        this.precios = precios;

        if (tieneDescuentoPaquete()) {
            total = precios.stream().mapToInt(Integer::intValue).sum() * 0.9;
        } else if (tieneDescuentoFuturo()) {
            total = precios.stream().mapToInt(Integer::intValue).sum() * 0.95;
        }
    }

    boolean tieneDescuentoPaquete() {
        boolean completo = true;
        for (int i = 1; i <= 4; i++) {
            completo = completo && reservas.contains(i);
        }
        return completo;
    }

    boolean tieneDescuentoFuturo() {
        return true;
    }

    boolean tieneDescuentoAHoteles() {
        return Collections.frequency(reservas, 1) > 1 ? true : false;
    }

    boolean tieneDescuentoAViajes() {
        return Collections.frequency(reservas, 3) > 1 ? true : false;
    }

    @Override
    public String toString() {
        return "Localizador:" +
                "Cliente=" + cliente +
                ", Total=" + total +
                ", Reservas=" + reservas;
    }
}
