package com.savetheropa;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        Prenda p1 = new Buzo("Zara", "A", "Buzo");
        Prenda p2 = new Campera("H&M", "B", "Campera");
        List<Prenda> lista = new ArrayList<>();

        lista.add(p1);
        lista.add(p2);
        GuardaRopa g = new GuardaRopa();
        System.out.println(g.guardarPrendas(lista));
        g.mostrarPrendas();
        List<Prenda> prendasPorID = g.devolverPrendas(2);
        if (prendasPorID == null) {
            System.out.println("No existen prendas con este ID.");
        } else {
            System.out.println(prendasPorID);
        }
    }


}


