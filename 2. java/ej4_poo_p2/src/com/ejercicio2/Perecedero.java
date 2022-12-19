package com.ejercicio2;

public class Perecedero extends Producto{

    private int diasPorCaducar;

    public Perecedero() {
    }

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
                "} " + super.toString();
    }

    @Override
    public double calcular(int cantidadDeProductos){
        double res;
        switch (diasPorCaducar){
            case 1:
                res=super.calcular(cantidadDeProductos)/4;
                break;
            case 2:
                res=super.calcular(cantidadDeProductos)/3;
                break;
            case 3:
                res=super.calcular(cantidadDeProductos)/2;
                break;
            default:
                res= (diasPorCaducar>0) ? super.calcular(cantidadDeProductos): 0;
        }
        return res;
    }
}
