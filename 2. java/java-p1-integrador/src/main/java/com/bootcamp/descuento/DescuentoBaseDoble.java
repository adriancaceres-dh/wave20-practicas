package com.bootcamp.descuento;

import com.bootcamp.localizador.Localizador;
import com.bootcamp.reserva.Reserva;
import com.bootcamp.reserva.TipoReserva;

import java.util.List;
import java.util.stream.Collectors;

public class DescuentoBaseDoble implements IDescuento {
    private Localizador localizador;

    public DescuentoBaseDoble(Localizador localizador) {
        this.localizador = localizador;
    }

    @Override
    public double aplicarDescuento() {
        List<Reserva> reservasHotel = localizador.getReservas().stream()
                .filter(r -> r.getTipo().equals(TipoReserva.HOTEL))
                .collect(Collectors.toList());

        List<Reserva> reservasPasajes = localizador.getReservas().stream()
                .filter(r -> r.getTipo().equals(TipoReserva.PASAJE))
                .collect(Collectors.toList());

        double total = 0;
        if (reservasHotel.size() >= 2)
            total += 0.05 * reservasHotel.stream().mapToDouble(r -> r.getCosto()).sum();
        if (reservasPasajes.size() >= 2)
            total += 0.05 * reservasPasajes.stream().mapToDouble(r -> r.getCosto()).sum();

        return total;
    }
}
