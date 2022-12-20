package com.bootcamp.ejercicio2;

public class Perecedero extends Producto{

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
    public String toString() {
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        double precio = super.calcular(cantidadDeProductos);
        switch (getDiasPorCaducar()){
            case (1):
                precio = precio - this.getPrecio()*4;
                break;
            case (2):
                precio = precio - this.getPrecio()*3;
                break;
            case (3):
                precio = precio - this.getPrecio()/2;
                break;
            default:
                break;
        }
        return precio;
    }
}
