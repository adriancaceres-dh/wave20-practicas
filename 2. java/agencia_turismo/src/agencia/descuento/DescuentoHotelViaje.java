package agencia.descuento;

import agencia.Localizador;
import agencia.reserva.Reserva;

public class DescuentoHotelViaje extends Descuento{
    public DescuentoHotelViaje(double porcentajeDescuento) {
        super(porcentajeDescuento);
    }

    @Override
    public boolean estaVigente() {
        return true;
    }

    @Override
    public boolean aplicaDescuento(Localizador localizador) {
        return localizador.getReservas().stream()
                .filter(reserva -> reserva.getTipoReserva().getNombre().equals("Hotel"))
                .count() >= 2
                || localizador.getReservas().stream()
                .filter(reserva -> reserva.getTipoReserva().getNombre().equals("Viaje"))
                .count() >= 2;
    }

    @Override
    public double calcularDescuento(Localizador localizador, double montoPrevio) {
        double descuento = 0;
        for (Reserva reserva : localizador.getReservas()) {
            String tipoReserva = reserva.getTipoReserva().getNombre();
            if (tipoReserva.equals("Hotel") || tipoReserva.equals("Viaje")) {
                descuento += reserva.getCosto() * (porcentajeDescuento / 100);
            }
        }
        return descuento;
    }
}
