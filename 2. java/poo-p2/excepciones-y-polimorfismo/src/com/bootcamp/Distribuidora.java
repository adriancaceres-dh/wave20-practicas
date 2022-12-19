package com.bootcamp;

public class Distribuidora {
    public static void main(String[] args) {
        //com.bootcamp.PracticaExcepciones.coeficiente(0, 200);

        Producto productoBase = new Producto("termotanque", 15000.45);
        Perecedero productoPerecederoSinCaducar = new Perecedero("Leche", 150,5);
        Perecedero productoPerecederoPorCaducar = new Perecedero("Queso", 500.66, 2);
        NoPerecedero productoNoPerecedero = new NoPerecedero("Agua", 85, "Líquido");
        Producto[] productos = {productoBase, productoPerecederoSinCaducar, productoPerecederoPorCaducar, productoNoPerecedero};

        for (Producto p : productos) {
            System.out.println(p.toString());
            System.out.println("Precio de 5 " + p.nombre + ": " + p.calcular(5) + "\n");
        }
    }
}