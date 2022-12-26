package com.bootcamp.clases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Prenda prenda1 = new Prenda("Zara", "Blusa");
        Prenda prenda2 = new Prenda("Zara", "Pantalon");
        Prenda prenda3 = new Prenda("Zara", "Camisa");
        Prenda prenda4 = new Prenda("Zara", "Short");
        Prenda prenda5 = new Prenda("Zara", "Camiseta");
        Prenda prenda6 = new Prenda("Zara", "Bufanda");

        ArrayList<Prenda> listaPrendas = new ArrayList<>();
        listaPrendas.add(prenda1);
        listaPrendas.add(prenda2);
        listaPrendas.add(prenda3);


        ArrayList<Prenda> listaPrendas2 = new ArrayList<>();
        listaPrendas2.add(prenda4);
        listaPrendas2.add(prenda5);
        listaPrendas2.add(prenda6);

        ///List<Prenda> listaPrendas3 = new Arrays.asList();


        GuardaRopa miGuardaRopa = new GuardaRopa();

        miGuardaRopa.guardarPrendas(listaPrendas);
        miGuardaRopa.guardarPrendas(listaPrendas2);

        miGuardaRopa.mostrarPrendas();


        System.out.println(miGuardaRopa.devolverPrendas(8));
    }
}
