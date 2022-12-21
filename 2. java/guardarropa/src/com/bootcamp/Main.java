package com.bootcamp;

import com.bootcamp.modelos.GuardaRopa;
import com.bootcamp.modelos.Prenda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Prenda> deportivo = new ArrayList<>(Arrays.asList(
                new Prenda("Nike", "Short"),
                new Prenda("Adidas", "Playera")
        ));

        List<Prenda> casual = new ArrayList<>(Arrays.asList(
                new Prenda("Gap", "Playera"),
                new Prenda("Levis", "Jeans")
        ));

        GuardaRopa guardaRopa = new GuardaRopa();

        // Guardar prendas
        Integer numeroDeportivo = guardaRopa.guardarPrendas(deportivo);
        Integer numeroCasual = guardaRopa.guardarPrendas(casual);

        // Mostrar prendas
        System.out.println();
        System.out.println("TODAS LAS PRENDAS:");
        guardaRopa.mostrarPrendas();

        // Devolver prendas
        System.out.println();
        System.out.println("PRENDAS SOLICITADAS: " + numeroDeportivo);
        System.out.println(guardaRopa.devolverPrendas(numeroDeportivo));

        System.out.println();
        System.out.println("PRENDAS SOLICITADAS: " + numeroCasual);
        System.out.println(guardaRopa.devolverPrendas(numeroCasual));
    }
}
