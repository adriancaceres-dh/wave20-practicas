package com.bootcamp;

public class Main {

    public static void main(String[] args) {
        SerieIntegerDos serieIntegerDos = new SerieIntegerDos(0);
        SerieShortTres serieShortTres = new SerieShortTres((short)0);

        System.out.println();
        System.out.println("SERIE DOS DE INTEGER NORMAL:");
        for(int i=0; i<4; i++) {
            System.out.println(serieIntegerDos.valorSiguiente());
        }

        serieIntegerDos.asignarValorInicial(1);

        System.out.println();
        System.out.println("SERIE DOS DE INTEGER CON VALOR INICIAL DE 1:");
        for(int i=0; i<4; i++) {
            System.out.println(serieIntegerDos.valorSiguiente());
        }

        System.out.println();
        System.out.println("SERIE TRES DE SHORT NORMAL:");
        for(int i=0; i<4; i++) {
            System.out.println(serieShortTres.valorSiguiente());
        }
    }
}
