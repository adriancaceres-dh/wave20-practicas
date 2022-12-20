package com.bootcamp;

public class App {
    public static void main(String[] args) {
        Short numero=Short.valueOf("5");
        Serie2 serie=new Serie2<>(numero);
        Serie3 serie3=new Serie3<>(numero);
        System.out.println(serie.valorSiguiente());
        System.out.println(serie.valorSiguiente());
        System.out.println(serie.valorSiguiente());
        System.out.println(serie.valorSiguiente());

        System.out.println(serie3.valorSiguiente());
        System.out.println(serie3.valorSiguiente());
        System.out.println(serie3.valorSiguiente());
        System.out.println(serie3.valorSiguiente());
    }


}
