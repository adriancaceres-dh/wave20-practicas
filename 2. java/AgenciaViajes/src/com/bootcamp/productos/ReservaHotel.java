package com.bootcamp.productos;

public class ReservaHotel extends Producto{

    private int dias;

    public ReservaHotel(double precio, int dias) {
        super(precio);
        this.dias = dias;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    @Override
    public String toString() {
        return "ReservaHotel{" +
                "dias=" + dias +
                '}';
    }
}
