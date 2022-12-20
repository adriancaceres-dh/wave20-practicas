package com.bootcamp;

public class Main {
    public static void main(String[] args) {
        Serie2 serie2 = new Serie2();

        //Inicializo la serie de 2 y le sumo valores:
        serie2.establecerInicial(0);
        System.out.println(serie2.valorSiguiente());
        System.out.println(serie2.valorSiguiente());
        System.out.println(serie2.valorSiguiente());

        //Inicializo la serie de 3 y pruebo metodos:
        Serie3 serie3 = new Serie3();
        serie3.establecerInicial(0);
        System.out.println(serie3.valorSiguiente());
        System.out.println(serie3.valorSiguiente());
        serie3.reiniciarSerie();
        System.out.println(serie3.valorSiguiente());


    }
}
