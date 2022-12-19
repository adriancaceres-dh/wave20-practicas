package com.bootcamp.Service;

import com.bootcamp.Entidad.NoPerecederos;
import com.bootcamp.Entidad.Perecederos;
import com.bootcamp.Entidad.Producto;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    public static  void create(){
        List<Producto> productos = new ArrayList<>();
        Producto pr = new NoPerecederos("P1", 50, "lata");
        Producto p1 = new Perecederos("p2",50,2);
        productos.add(pr);
        productos.add(p1);
        System.out.println(productos.get(0).calcular(10));
        System.out.println(productos.get(1).calcular(10));

    }


}
