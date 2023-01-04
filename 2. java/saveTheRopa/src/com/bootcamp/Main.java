package com.bootcamp;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GuardaRopa guardaRopa = new GuardaRopa();

        List<Prenda> prendasMessi = new ArrayList<>();
        prendasMessi.add(new Prenda("Adidas", "Campeon"));
        prendasMessi.add(new Prenda("Adidas", "La tercera"));

        int idPrendasMessi = guardaRopa.guardarPrendas(prendasMessi);

        System.out.println("Prendas en el guarda ropas: \n");
        guardaRopa.mostrarPrendas();

        System.out.println("Devolviendo prendas: \n");
        List<Prenda> devolucion = guardaRopa.devolverPrendas(idPrendasMessi);
        for (Prenda p : devolucion){
            System.out.println(p);
        }


    }
}
