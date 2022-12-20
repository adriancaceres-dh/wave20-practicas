package agencia.descuento;

import agencia.Localizador;

public abstract class Descuento {
    private double porcentajeDescuento;
    public abstract boolean estaVigente();
    public abstract boolean aplicaDescuento(Localizador localizador);

    public Descuento(double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }
}
