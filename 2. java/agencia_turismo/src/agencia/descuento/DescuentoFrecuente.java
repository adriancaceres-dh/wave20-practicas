package agencia.descuento;

import agencia.Localizador;

public class DescuentoFrecuente extends Descuento{

    public DescuentoFrecuente(double porcentajeDescuento) {
        super(porcentajeDescuento);
    }

    @Override
    public boolean estaVigente() {
        return true;
    }

    @Override
    public boolean aplicaDescuento(Localizador localizador) {
        return localizador.getCliente().getLocalizadores().size() >= 2;
    }
}
