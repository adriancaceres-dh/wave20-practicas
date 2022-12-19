package com.bootcamp;

public class Perecedero extends Producto {
    private int diasPorCaducar;

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        double valorTotal = cantidadDeProductos * getPrecio();
        if (diasPorCaducar == 1) {
            valorTotal = valorTotal / 4;
        } else if (diasPorCaducar == 2) {
            valorTotal = valorTotal / 3;
        } else if (diasPorCaducar == 3) {
            valorTotal = valorTotal / 2;
        }
        return valorTotal;
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public String toString() {
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }
}
