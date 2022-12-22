package com.bootcamp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args){

        int identificador; List<Prenda> prendasDevueltas;
        GuardaRopa guardaRopa = new GuardaRopa();

        /* una forma de inicializar un array list con valores */
        List<Prenda> primerasPrendas = new ArrayList<Prenda>(){
            {
                add(new Prenda("campera DC","Con capucha"));
                add(new Prenda("Zapatilla Nike","roja"));
            }
        };

        /* otra forma mas practica de inicializar un array list con valores */
        List<Prenda> segundasPrendas = new ArrayList<Prenda>(
                Arrays.asList(new Prenda("camisa Mistral","manga corta verano"),
                        new Prenda("Zapatilla DC","bajas azules")));

        List<List<Prenda>> prendas = new LinkedList<>(Arrays.asList(primerasPrendas,segundasPrendas)) ;

        for (List<Prenda> prendasGuardadas : prendas){
            System.out.println("---");
            guardaRopa.mostrarPrendas(); // antes de guardar prendas
            identificador = guardaRopa.guardarPrendas(prendasGuardadas);
            guardaRopa.mostrarPrendas(); // luego de guardar prendas
            prendasDevueltas = guardaRopa.devolverPrendas(identificador);
            System.out.println(prendasDevueltas);
        }
    }
}
