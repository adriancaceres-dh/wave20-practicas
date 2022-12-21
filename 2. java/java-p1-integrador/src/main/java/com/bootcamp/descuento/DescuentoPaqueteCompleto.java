package com.bootcamp.descuento;

import com.bootcamp.localizador.Localizador;
import com.bootcamp.reserva.Reserva;
import com.bootcamp.reserva.TipoReserva;

import java.util.List;
import java.util.stream.Collectors;

public class DescuentoPaqueteCompleto implements IDescuento {
    private Localizador localizador;

    public DescuentoPaqueteCompleto(Localizador localizador) {
        this.localizador = localizador;
    }

    @Override
    public double aplicarDescuento() {
        List<Reserva> reservasHotel = localizador.getReservas().stream()
                .filter(r -> r.getTipo().equals(TipoReserva.HOTEL))
                .collect(Collectors.toList());
        if (reservasHotel.size() == 0) return 0;

        List<Reserva> reservasPasajes = localizador.getReservas().stream()
                .filter(r -> r.getTipo().equals(TipoReserva.PASAJE))
                .collect(Collectors.toList());
        if (reservasPasajes.size() == 0) return 0;

        List<Reserva> reservasTraslados = localizador.getReservas().stream()
                .filter(r -> r.getTipo().equals(TipoReserva.TRASLADOS))
                .collect(Collectors.toList());
        if (reservasTraslados.size() == 0) return 0;

        List<Reserva> reservasAlimentacion = localizador.getReservas().stream()
                .filter(r -> r.getTipo().equals(TipoReserva.ALIMENTACION))
                .collect(Collectors.toList());
        if (reservasAlimentacion.size() == 0) return 0;

        return 0.10 * localizador.subTotal();
    }
}
