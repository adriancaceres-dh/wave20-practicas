package com.series_numericas;

import java.util.Scanner;

public class App {

    private static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {

        SerieA serieA = new SerieA();
        SerieB serieB = new SerieB();

        System.out.println("Ingrese el número inicial de la serie A");
        Number inicio = input.nextInt();
        System.out.println("Ingrese la cantidad de miembros de la serie que dea ver");
        int iteraciones = input.nextInt();
        serieA.valorInicial(inicio);
        for (int i = 0; i < iteraciones; i++) {
            System.out.println("Valor nº "+i+ " de la serie numérica A: "+serieA.siguiente());
        }
        serieA.reiniciar();
        System.out.println("Ingrese el número inicial de la serie B");
        Number init = input.nextInt();
        System.out.println("Ingrese la cantidad de miembros de la serie que desea ver");
        int it = input.nextInt();
        serieB.valorInicial(init);
        for (int j = 0; j < it; j++) {
            System.out.println("Valor nº "+j+ " de la serie numérica B: "+serieB.siguiente());
        }
        serieB.reiniciar();
    }
}
