package com.bootcamp;

public class Perecedero extends Producto {

    private int diasPorCaducar;

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        double precioFinal =  super.calcular(cantidadDeProductos);
        precioFinal = switch (this.diasPorCaducar) {
            case 1 -> precioFinal / 4;
            case 2 -> precioFinal / 3;
            case 3 -> precioFinal / 2;
            default -> precioFinal;
        };
        return precioFinal;
    }

    @Override
    public String toString() {
        return super.toString() + ". Dias por caducar: " + this.diasPorCaducar;
    }
}
