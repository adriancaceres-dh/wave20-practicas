package com.bootcamp;

import java.util.ArrayList;

public class Distribuidora {

    public static void main(String[] args) {

        ArrayList<Producto> productosPerecederos = new ArrayList<>();
        ArrayList<Producto> productosNoPerecederos = new ArrayList<>();

        Producto producto = new NoPerecedero("Fosforos", 120, "Almacen");
        productosNoPerecederos.add(producto);
        productosNoPerecederos.add(producto);
        productosNoPerecederos.add(producto);
        productosNoPerecederos.add(producto);
        productosNoPerecederos.add(producto);

        Perecedero producto1 = new Perecedero("Leche", 60,2);
        productosPerecederos.add(producto1);
        productosPerecederos.add(producto1);
        productosPerecederos.add(producto1);
        productosPerecederos.add(producto1);
        productosPerecederos.add(producto1);

        double totalNoPredecederos=0;
        for(int i=0;i<productosNoPerecederos.size();i++){
            totalNoPredecederos += productosNoPerecederos.get(i).calcular(1);
        }
        System.out.println("Total productos no predecederos $" + totalNoPredecederos);

        double totalPerecederos=0;
        for(int i=0;i<productosPerecederos.size();i++){
            totalPerecederos += productosPerecederos.get(i).calcular(1);
        }
        System.out.println("Total productos predecederos $" + totalPerecederos);

    }
}
