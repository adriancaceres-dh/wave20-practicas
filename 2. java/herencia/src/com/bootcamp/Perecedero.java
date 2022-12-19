package com.bootcamp;

public class Perecedero extends Producto{
    int diasPorCaducar;

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
        double precio_inicial=super.calcular(cantidadDeProductos);
        if (diasPorCaducar==1){
            return precio_inicial/4;
        } else if (diasPorCaducar==2) {
            return precio_inicial/3;
        } else if (diasPorCaducar==3) {
            return precio_inicial/2;
        }else return super.calcular(cantidadDeProductos);

    }
}
