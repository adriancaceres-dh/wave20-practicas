package com.bootcamp;

public class Perecedero extends Producto{
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
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        double resultado = 0;

        switch (diasPorCaducar) {
            case 1:
                resultado += super.calcular(cantidadDeProductos) / 4;
                break;
            case 2:
                resultado += super.calcular(cantidadDeProductos) / 3;
                break;
            case 3:
                resultado += super.calcular(cantidadDeProductos) / 2;
                break;
            default:
                resultado += super.calcular(cantidadDeProductos);
        }

        return resultado;
    }
}
