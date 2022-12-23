package com.bootcamp;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args){

        GuardaRopa guardaRopa = new GuardaRopa();
        Prenda prenda1 = new Prenda("Adidas", "a");
        Prenda prenda2 = new Prenda("Puma", "b");
        List<Prenda> prendas= new ArrayList<>();
        prendas.add(prenda1);
        prendas.add(prenda2);
        int identificador = guardaRopa.guardarPrendas(prendas);

        guardaRopa.mostrarPrendas();

        guardaRopa.devolverPrendas(identificador);
        
        System.out.println();
        guardaRopa.mostrarPrendas();
    }
}
