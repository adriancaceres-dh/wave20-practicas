package com.bootcamp.utils;

import com.bootcamp.Localizador;
import com.bootcamp.reservas.*;

import java.util.List;
import java.util.stream.Collectors;

public class ReservasGetterUtil {

    public static List<Reserva> getReservasHotel(Localizador localizador) {
        return localizador
                .getReservas()
                .stream()
                .parallel()
                .filter(ReservaHotel.class::isInstance)
                .collect(Collectors.toList());
    }

    public static List<Reserva> getReservasBoletosViaje(Localizador localizador) {
        return localizador
                .getReservas()
                .stream()
                .parallel()
                .filter(BoletoViaje.class::isInstance)
                .collect(Collectors.toList());
    }

    public static List<Reserva> getReservasComida(Localizador localizador) {
        return localizador
                .getReservas()
                .stream()
                .parallel()
                .filter(Comida.class::isInstance)
                .collect(Collectors.toList());
    }

    public static List<Reserva> getReservasTransporte(Localizador localizador) {
        return localizador
                .getReservas()
                .stream()
                .parallel()
                .filter(Transporte.class::isInstance)
                .collect(Collectors.toList());
    }


}
