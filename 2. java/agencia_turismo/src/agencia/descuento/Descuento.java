package agencia.descuento;

import agencia.Localizador;

public abstract class Descuento {
    protected double porcentajeDescuento;
    public abstract boolean estaVigente();
    public abstract boolean aplicaDescuento(Localizador localizador);
    public abstract double calcularDescuento(Localizador localizador, double montoPrevio);

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
