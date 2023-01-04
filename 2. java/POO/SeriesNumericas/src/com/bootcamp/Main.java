package com.bootcamp;

public class Main {
    public static void main(String[] args) {
        Prototype<Integer> serieInteger = new PrototypeInteger(3);

        System.out.println(serieInteger.valorSiguiente());
        System.out.println(serieInteger.valorSiguiente());
        System.out.println(serieInteger.valorSiguiente());
        serieInteger.reiniciarSerie();
        System.out.println(serieInteger.valorSiguiente());
        System.out.println(serieInteger.valorSiguiente());
        System.out.println(serieInteger.valorSiguiente());
        System.out.println(serieInteger.valorSiguiente());
        serieInteger.reiniciarSerie();
        serieInteger.iniciarSerie(4); // 4 + 3 = 7
        System.out.println(serieInteger.valorSiguiente()); // de 3 en 3 (linea 5) -> 7 + 3 =10
        System.out.println(serieInteger.valorSiguiente());


    }
}