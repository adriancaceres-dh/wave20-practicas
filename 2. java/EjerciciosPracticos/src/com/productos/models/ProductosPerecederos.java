package com.productos.models;

public class ProductosPerecederos extends Productos{


    private int diasPorCaducar;

    public ProductosPerecederos() {

    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public ProductosPerecederos(String nombre, Double precio) {
        super(nombre, precio);
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public int calcular(int cantidadDeProductos) {

         int calculado  = super.calcular(cantidadDeProductos);

         if (diasPorCaducar == 1){
             calculado = calculado / 4;
         }

         if (diasPorCaducar == 2) {
             calculado = calculado / 3;
         }

         if (diasPorCaducar == 3) {
             calculado = calculado / 2;
         }

         return calculado;
    }

    @Override
    public String toString() {
        return super.toString() +
                "ProductosPerecederos{" +
                "diasPorCaducar='" + diasPorCaducar + '\'' +
                '}';
    }

}
