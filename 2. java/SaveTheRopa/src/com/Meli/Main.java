package com.Meli;

import com.Meli.mode.GuardaRopa;
import com.Meli.mode.Prenda;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        GuardaRopa guardaRopa = new GuardaRopa();

        guardaRopa.guardarPrendas(List.of(new Prenda("a","b"), new Prenda("Holis", "Adios")));
        guardaRopa.guardarPrendas(List.of(new Prenda("x","y")));

        guardaRopa.mostrarPrendas();

        guardaRopa.devolverPrendas(1).forEach(p -> System.out.println(p.toString()));
    }

}
