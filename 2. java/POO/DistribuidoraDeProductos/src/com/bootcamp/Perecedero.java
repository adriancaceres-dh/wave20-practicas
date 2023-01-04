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
    double calcular(int cantidadDeProductos) {

        double total = this.getPrecio() * cantidadDeProductos;

        if(diasPorCaducar == 0) {
            System.out.println("El producto ha caducado y no puede ser vendido");
        } else if(diasPorCaducar == 1) {
           total = total / 4;
        } else if(diasPorCaducar == 2) {
            total = total/3;
        } else if(diasPorCaducar == 3) {
            total = total / 2;
        } else {
            total = total;
        }
        return total;
    }
}
