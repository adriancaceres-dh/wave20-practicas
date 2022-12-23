package com.bootcamp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Prenda remera = new Prenda("Nike","Remera");
        Prenda pantalon = new Prenda("Nike","Pantalon");

        HashMap<Integer,List<Prenda>> diccionario = new HashMap<Integer, List<Prenda>>();
        GuardaRopa guardaRopa= new GuardaRopa(diccionario,0);


        //prendas
        ArrayList<Prenda> prendas = new ArrayList<>(Arrays.asList(remera,pantalon));
        int nro = guardaRopa.guardarPrendas(prendas);
        System.out.println("Identificador de prendas guardadas : "+nro);


        guardaRopa.mostrarPrendas();

        System.out.println("Devolviendo prendas de identificador "+nro+" ..");
        System.out.println(guardaRopa.devolverPrendas(nro));
    }
}
