package com.bootcamp;

public class Perecedero extends Producto {
    int diasPorCaducar;

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
    public String toString() {
        String salida = "com.bootcamp.Perecedero\n";
        salida += super.toString();
        salida += "Dias por caducar: " + this.diasPorCaducar + "\n";
        return salida;
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        double precioTotal = super.calcular(cantidadDeProductos);
        if (diasPorCaducar <= 3) {
            precioTotal /= 5-diasPorCaducar;
        }
        return Math.round(precioTotal);
    }
}
