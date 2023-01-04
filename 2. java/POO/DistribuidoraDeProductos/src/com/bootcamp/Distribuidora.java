package com.bootcamp;

public class Distribuidora {
    public static void main(String[] args) {
        double totalAPagarPerecederos = 0;
        double totalAPagarNoPerecederos = 0;

        Perecedero perecedero = new Perecedero("Fideos", 300, 3);
        Perecedero perecedero1 = new Perecedero("Polenta", 200, 5);
        Perecedero perecedero2 = new Perecedero("Huevos", 510, 2);
        Perecedero perecedero3 = new Perecedero("Leche", 350, 4);
        Perecedero perecedero4 = new Perecedero("Yogurt", 210, 1);

        NoPerecedero noPerecedero = new NoPerecedero("Azucar", 300, "no perecedero");
        NoPerecedero noPerecedero1 = new NoPerecedero("Aceite", 400, "no perecedero");
        NoPerecedero noPerecedero2 = new NoPerecedero("Harina de trigo", 550, "no perecedero");
        NoPerecedero noPerecedero3 = new NoPerecedero("Café", 250, "no perecedero");
        NoPerecedero noPerecedero4 = new NoPerecedero("Arroz", 200, "no perecedero");

        double[] productosPerecederos = new double[5];
        double[] productosNoPerecederos = new double[5];

        productosPerecederos[0] = perecedero.calcular(1);
        productosPerecederos[1] = perecedero1.calcular(1);
        productosPerecederos[2] = perecedero2.calcular(3);
        productosPerecederos[3] = perecedero3.calcular(5);
        productosPerecederos[4] = perecedero4.calcular(2);

        productosNoPerecederos[0] = noPerecedero.calcular(5);
        productosNoPerecederos[1] = noPerecedero1.calcular(3);
        productosNoPerecederos[2] = noPerecedero2.calcular(2);
        productosNoPerecederos[3] = noPerecedero3.calcular(3);
        productosNoPerecederos[4] = noPerecedero4.calcular(1);

        for (int i=0; i<productosPerecederos.length; i++) {
            totalAPagarPerecederos = totalAPagarPerecederos + productosPerecederos[i];
            }

        for (int i=0; i<productosNoPerecederos.length; i++) {
            totalAPagarNoPerecederos = totalAPagarNoPerecederos + productosNoPerecederos[i];
        }

        System.out.println("El total a pagar de productos perecederos es= " + totalAPagarPerecederos);

        System.out.println("El total a pagar de productos no perecederos es= " + totalAPagarNoPerecederos);
    }
}