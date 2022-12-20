package agencia.descuento;

import agencia.Localizador;

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
}
