package com.ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora2 {


    private static double calcularProductos(List<Producto> lista){
        double total=0;
        for (Producto p : lista){
            total+= p.calcular(5);
        }
        return  total;
    }

    public static void main (String[] args){

        Producto p1 = new Perecedero("item1",10,2);
        Producto p2 = new Perecedero("item2",20,3);
        Producto p3 = new Perecedero("item3",2,10);
        Producto p4 = new NoPerecedero("item4",25.3,"tipo1");
        Producto p5 = new NoPerecedero("item5", 101.13,"tipo2");
        Producto p6 = new Perecedero("item6", 821654, -14);

        List<Producto> listaProductos = new ArrayList<Producto>();

        listaProductos.add(p1);
        listaProductos.add(p2);
        listaProductos.add(p3);
        listaProductos.add(p4);
        listaProductos.add(p5);
        listaProductos.add(p6);

        System.out.println(calcularProductos(listaProductos));

    }

}
