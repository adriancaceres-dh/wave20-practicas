package com.bootcamp;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Prenda p1 = new Prenda("Givenchy", "Camisa L");
        Prenda p2 = new Prenda("Dior", "Blusa azul");
        Prenda p3 = new Prenda("Prune", "Jean Roto");
        Prenda p4 = new Prenda("Siamo Fuori", "Bermuda Hombre");


        List<Prenda> prendas1 = new ArrayList<>();
        List<Prenda> prendas2 = new ArrayList<>();

        prendas1.add(p1);
        prendas1.add(p2);
        prendas2.add(p3);
        prendas2.add(p4);

        GuardaRopa gr = new GuardaRopa();
        Integer guardado1 = gr.guardarPrendas(prendas1);
        Integer guardado2 = gr.guardarPrendas(prendas2);

        gr.mostrarPrendas();

        gr.devolverPrendas(guardado1);
    }
}