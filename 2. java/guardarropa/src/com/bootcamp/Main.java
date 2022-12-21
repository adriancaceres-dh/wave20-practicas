package com.bootcamp;

import com.bootcamp.modelos.GuardaRopa;
import com.bootcamp.modelos.Prenda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Prenda> prendas = new ArrayList<>(Arrays.asList(
                new Prenda("marca1", "modelo1"),
                new Prenda("marca2", "modelo2")
        ));

        List<Prenda> prendas2 = new ArrayList<>(Arrays.asList(
                new Prenda("marca3", "modelo3"),
                new Prenda("marca4", "modelo4")
        ));

        GuardaRopa guardaRopa = new GuardaRopa();

        // Guardar prendas
        Integer numero = guardaRopa.guardarPrendas(prendas);
        Integer numero2 = guardaRopa.guardarPrendas(prendas2);

        // Mostrar prendas
        System.out.println();
        System.out.println("TODAS LAS PRENDAS:");
        guardaRopa.mostrarPrendas();

        // Devolver prendas
        System.out.println();
        System.out.println("PRENDA SOLICITADA: " + numero);
        System.out.println(guardaRopa.devolverPrendas(numero));
    }
}
