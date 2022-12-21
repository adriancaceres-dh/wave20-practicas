package com.bootcamp;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Prenda prenda1 = new Prenda("Adidas", "Camiseta");
        Prenda prenda2 = new Prenda("Nike", "Camiseta");
        Prenda prenda3 = new Prenda("Puma", "Camiseta");
        Prenda prenda4 = new Prenda("Reebok", "Camiseta");

        GuardaRopa guardaRopa = new GuardaRopa();
        List<Prenda> listaPrendas = new ArrayList<>();

        listaPrendas.add(prenda1);
        listaPrendas.add(prenda2);
        listaPrendas.add(prenda3);
        listaPrendas.add(prenda4);

        System.out.println("Su número de identificación es: " + guardaRopa.guardarPrendas(listaPrendas));
        guardaRopa.mostrarPrendas();
        System.out.println("Las prendas con el número ingresado son: " + guardaRopa.devolverPrendas(1));
    }
}
