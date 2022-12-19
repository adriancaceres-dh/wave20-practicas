package com.bootcamp;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    public  static void ejecutar(){
        Producto producto1=new Perecedero("pan",2500,3);
        /*
        Producto producto2=new Perecedero("salchicha",5000,2);
        Producto producto3=new Perecedero("jamon",2000,1);
        Producto producto4=new Perecedero("carne",5000,3);
        Producto producto5=new Perecedero("tomate",2500,1);
        */
        Producto producto6=new NoPerecedero("atun",3000,"proteina");
        /*
        Producto producto7=new NoPerecedero("arroz",2500,"cereal");
        Producto producto8=new NoPerecedero("pasta",3000,"harina");
        Producto producto9=new NoPerecedero("sardina",4000,"proteina");
        Producto producto10=new NoPerecedero("lenteja",3000,"grano");
        */
        List<Producto> productos=new ArrayList<>();
        productos.add(producto1);
        productos.add(producto6);
        /*
        productos.add(producto2);
        productos.add(producto3);
        productos.add(producto4);
        productos.add(producto5);
        productos.add(producto7);
        productos.add(producto8);
        productos.add(producto9);
        productos.add(producto10);
        */


        double total=0;
        for (Producto product:productos) {
            total+=product.calcular(5);
        }
        System.out.println("Precio total $"+total);
    }



}
