package com.mercadolibre;

import com.mercadolibre.modelos.GuardaRopa;
import com.mercadolibre.modelos.Prenda;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Prenda camisa = new Prenda("Carolina Herrera","Camisa");
        Prenda jean = new Prenda("Levi's","Jean");
        Prenda bolso = new Prenda("Gucci","bolso");
        Prenda reloj = new Prenda("Fossil","reloj");
        Prenda buso = new Prenda("Gucci","Busso");

        List<Prenda>lista1 = new ArrayList<>();
        lista1.add(camisa);
        lista1.add(jean);

        List<Prenda>lista2 = new ArrayList<>();
        lista2.add(bolso);
        lista2.add(reloj);
        lista2.add(buso);

        GuardaRopa gp1 = new GuardaRopa();
        gp1.guardarPrendas(lista1);
        gp1.guardarPrendas(lista2);
        System.out.println("------------------------------");
        gp1.mostrarPrendas();
        System.out.println("------------------------------");
        List<Prenda> prendasEncontradas = gp1.devolverPrendas(4);
        if (prendasEncontradas != null){
            System.out.println("prendasEncontradas = " + prendasEncontradas);
        }
    }
}
