package com.bootcamp;

public class Perecedero extends Producto{
    private int diasPorCaducar;

    public Perecedero() {}
    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public double calcular(int cantidadDeProductos){
        double resultado = super.calcular(cantidadDeProductos);
        if(diasPorCaducar == 1){
            resultado = (precio*cantidadDeProductos)/4;
        }
        if(diasPorCaducar == 2){
            resultado = (precio*cantidadDeProductos)/3;
        }
        if(diasPorCaducar == 3){
            resultado = (precio+cantidadDeProductos)/2;
        }
        return resultado;
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
}
