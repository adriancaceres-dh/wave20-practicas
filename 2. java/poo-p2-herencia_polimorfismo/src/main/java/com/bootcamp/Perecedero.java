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
        int cociente = diasPorCaducar <= 3 ? 5 - diasPorCaducar : 1;
        return cantidadDeProductos * getPrecio() / cociente;
    }

    @Override
    public String toString() {
        return String.format("%-20s | $ %7.2f | %3d días",getNombre(),getPrecio(),diasPorCaducar);
    }
}
