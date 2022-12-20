package com.bootcamp.clases;

import com.bootcamp.clases.reservas.Reserva;
import com.bootcamp.clases.reservas.ReservaBoletosViaje;
import com.bootcamp.clases.reservas.ReservaHotel;

import java.util.*;
import java.util.stream.Collectors;

public class Repositorio {
    private final List<Localizador> localizadores;
    private final Set<String> clientes;
    private int reservasDistintas;

    public Repositorio(int reservasDistintas) {
        localizadores = new ArrayList<>();
        clientes = new HashSet<>();
        this.reservasDistintas = reservasDistintas;
    }

    public int getReservasDistintas() {
        return reservasDistintas;
    }

    public void setReservasDistintas(int reservasDistintas) {
        this.reservasDistintas = reservasDistintas;
    }

    public boolean agregarLocalizador(Cliente cliente, List<Reserva> reservas) {
        double precioTotal = reservas.stream().mapToDouble(Reserva::getPrecio).sum();
        double precioFinal = calcularPrecioFinal(cliente.getDni(), reservas);

        Localizador compra = new Localizador(cliente, reservas, precioTotal, precioFinal);
        clientes.add(cliente.getDni());
        detallesDeCompra(compra);
        return localizadores.add(compra);
    }

    private Map<String, Integer> clasificarReservas(List<Reserva> reservas) {
        Map<String, Integer> clasificadas = new HashMap<>();
        reservas.forEach(r -> clasificadas.put(r.getTipo(), clasificadas.getOrDefault(r.getTipo(), 0) + 1));
        return clasificadas;
    }

    private double calcularPrecioFinal(String dni, List<Reserva> reservas) {
        Map<String, Integer> clasificadas = clasificarReservas(reservas);

        // Se calculan los descuentos totales
        float descuento = 0f;
        if(descuentoPaqueteCompleto(clasificadas))  descuento += 0.10f;
        if(descuentoDosLocalizadores(dni))          descuento += 0.05f;

        // Se calculan los descuentos por reserva
        Set<String> tiposConDescuento = obtenerDescuentosParaHotelOViaje(clasificadas);
        // Aplica un descuento a cada reserva de HOTEL o VIAJE, solo si cada tipo fue reservado dos veces o más
        reservas.forEach(r -> {
            if(tiposConDescuento.contains(r.getTipo()))
                r.setPrecio(r.getPrecio() * 0.95);
        });

        return reservas.stream().mapToDouble(Reserva::getPrecio).sum() * (1.0 - descuento);
    }

    // Se evalúa el número de veces que el cliente ha realizado compras anteriormente
    private boolean descuentoDosLocalizadores(String dni) {
        if(!clientes.contains(dni)) return false;
        int comprasAnteriores = (int)localizadores.stream().filter(l -> dni.equals(l.getCliente().getDni())).count();
        return comprasAnteriores >= 2;
    }

    // Compara el tamaño de los tipos existentes con el número de tipos de reserva posibles
    private boolean descuentoPaqueteCompleto(Map<String, Integer> reservas) {
        return reservas.keySet().size() == reservasDistintas;
    }

    // Devuelve un set con los tipos de reserva, solamente de HOTEL y VIAJE, que tengan más de dos reservas
    private Set<String> obtenerDescuentosParaHotelOViaje(Map<String, Integer> reservas) {
        Set<String> tiposConDescuento = new HashSet<>();
        for(Map.Entry<String, Integer> reserva : reservas.entrySet()) {
            String tipo = reserva.getKey();
            if(tipo.equals(ReservaHotel.getTipoReserva()) || tipo.equals(ReservaBoletosViaje.getTipoReserva())) {
                if(reserva.getValue() >= 2) tiposConDescuento.add(tipo);
            }
        }
        return tiposConDescuento;
    }

    private void detallesDeCompra(Localizador localizador) {
        System.out.println("DETALLES DE LA COMPRA:");
        System.out.println(localizador);
    }
}
