package com.bootcamp;

import com.bootcamp.reservas.Reserva;
import com.bootcamp.utils.ReservasGetterUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnalizadorLocalizadores {
    private List<Localizador> localizadores;

    public AnalizadorLocalizadores() {
        localizadores = new ArrayList<>();
    }

    public void addLocalizador(Localizador localizador) {
        localizadores.add(localizador);
    }

    public int cantidadLocalizadoresVendidos() {
        return localizadores.size();
    }

    public int cantidadTotalReservas() {
        return localizadores.stream()
                .map(l -> l.getReservas().size())
                .mapToInt(p -> p)
                .sum();
    }

    public double cantidadTotalVentas() {
        return localizadores.stream()
                .mapToDouble(Localizador::getTotalACobrar)
                .sum();
    }

    public double promedioTotalVentas() {
        return cantidadTotalVentas() / cantidadTotalReservas();
    }

    public Map<String, List<Reserva>> mapaReservas() {
        Map<String, List<Reserva>> mapaReservas = obtenerMapaBase();
        for (Localizador localizador : localizadores) {
            List<Reserva> hotelesActuales = mapaReservas.get("Hoteles");
            List<Reserva> comidasActuales = mapaReservas.get("Comidas");
            List<Reserva> boletosActuales = mapaReservas.get("Boletos");
            List<Reserva> transporteActuales = mapaReservas.get("Transporte");

            hotelesActuales.addAll(ReservasGetterUtil.getReservasHotel(localizador));
            comidasActuales.addAll(ReservasGetterUtil.getReservasComida(localizador));
            boletosActuales.addAll(ReservasGetterUtil.getReservasBoletosViaje(localizador));
            transporteActuales.addAll(ReservasGetterUtil.getReservasTransporte(localizador));

        }
        return mapaReservas;
    }

    private Map<String, List<Reserva>> obtenerMapaBase() {
        Map<String, List<Reserva>> mapaReservas = new HashMap<>();
        mapaReservas.put("Hoteles", new ArrayList<>());
        mapaReservas.put("Comidas", new ArrayList<>());
        mapaReservas.put("Boletos", new ArrayList<>());
        mapaReservas.put("Transporte", new ArrayList<>());
        return mapaReservas;
    }

}
