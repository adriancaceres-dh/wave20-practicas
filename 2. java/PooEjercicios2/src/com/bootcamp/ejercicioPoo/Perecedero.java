package com.bootcamp.ejercicioPoo;

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
    public double calcular(int cantidadDeProductos) {
        double resultado = super.calcular(cantidadDeProductos);
        switch (diasPorCaducar){
            case 1:

                resultado = resultado/4;
                break;

            case 2:
                resultado = resultado/3;
                break;

            case 3:
                resultado = resultado/2;
                break;

        }
        
        return resultado;
    }

    @Override
    public String toString() {
        return super.toString() + " "+
        "dias por caducar='" +diasPorCaducar
                + '}';
    }
}
