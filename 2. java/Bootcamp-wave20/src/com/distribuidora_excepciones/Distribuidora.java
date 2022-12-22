package com.distribuidora_excepciones;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {

    private static List<Producto> productos = new ArrayList<>();

    public static void main(String[] args) {
        Producto p1 = new Perecedero("leche", 100.5, 2);
        Producto p2 = new NoPerecedero("polenta", "pole", 400.4 );
        Producto p3 = new Producto("carne", 500D);

        productos.add(p1);
        productos.add(p2);
        productos.add(p3);

        for (Producto p : productos) {
            double precioFinal = p.calcular(5);
            System.out.println("El producto es: "+p.getNombre());
            System.out.println("El precio total al vender 5 productos es de: "+precioFinal);
        }
    }


}
