package com.bootcamp;

public class App {
    public static void main(String[] args) {
        Short numero=Short.valueOf("5");
        Serie serie=new Serie<>(numero);
        System.out.println(serie.valorSiguiente());
        System.out.println(serie.valorSiguiente());
        System.out.println(serie.valorSiguiente());
        System.out.println(serie.valorSiguiente());
    }


}
