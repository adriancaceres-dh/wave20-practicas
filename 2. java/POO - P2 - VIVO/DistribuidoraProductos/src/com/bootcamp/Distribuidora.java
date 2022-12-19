package com.bootcamp;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {

    public static void main(String[] args) {
        List<Producto> productos = new ArrayList<Producto>();

        productos.add(new Perecedero("Yogurt", 5.0, 1));
        productos.add(new Perecedero("Queso", 15.0, 2));
        productos.add(new Perecedero("Jamón", 25.0, 3));
        productos.add(new Perecedero("Jugo de Manzana", 10.0, 15));
        productos.add(new Perecedero("Mermelada de Mango", 3.0, 3));
        productos.add(new NoPerecedero("Zapatos", 50.0, "Calzado"));
        productos.add(new NoPerecedero("Mochila", 30.0, "Accesorios"));
        productos.add(new NoPerecedero("Remera", 20.0, "Vestimenta Masculina"));
        productos.add(new NoPerecedero("Pantalón", 40.0, "Vestimenta Masculina"));
        productos.add(new NoPerecedero("Mesa", 80.0, "Hogar"));

        for(Producto p: productos){
            System.out.println("El precio del producto: " + p + " es: " + p.calcular(5));
        }
    }
}
