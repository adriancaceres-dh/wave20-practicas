package com.distribuidora_excepciones;

public class Perecedero extends Producto {

    private int diasPorCaducar;

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public String toString() {
        String data = "Nombre= " + getNombre() +
                  "Precio= " + getPrecio();
        return "Perecedero{" + data +
                "diasPorCaducar=" + diasPorCaducar;

    }

    @Override
    public double calcular(int cantidadDeProductos) {

        double nuevoPrecio = super.getPrecio();
        if (diasPorCaducar == 1) nuevoPrecio = getPrecio() / 4;

        if (diasPorCaducar == 2) nuevoPrecio = getPrecio() / 3;

        if (diasPorCaducar == 3) nuevoPrecio = getPrecio() / 2;

        return nuevoPrecio * cantidadDeProductos;
    }
}
