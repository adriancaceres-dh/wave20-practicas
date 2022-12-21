package agencia.descuento;

import agencia.Localizador;

public class DescuentoPaqueteCompleto extends Descuento {

    public DescuentoPaqueteCompleto(double porcentajeDescuento) {
        super(porcentajeDescuento);
    }

    @Override
    public boolean estaVigente() {
        return true;
    }

    @Override
    public boolean aplicaDescuento(Localizador localizador) {
        return localizador.getReservas().stream()
                .anyMatch(reserva -> reserva.getTipoReserva().getNombre().equals("Completa"));
    }

    @Override
    public double calcularDescuento(Localizador localizador, double montoPrevio) {
        return montoPrevio * (porcentajeDescuento / 100);
    }
}
