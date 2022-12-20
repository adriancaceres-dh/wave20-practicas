package com.bootcamp;

public class Main {

    public static void main(String[] args) {
        SerieDos serieDos = new SerieDos(Integer.valueOf(0));
        SerieTres serieTres = new SerieTres(Double.valueOf(0.0));

        System.out.println();
        System.out.println("SERIE DOS NORMAL:");
        for(int i=0; i<4; i++) {
            System.out.println(serieDos.valorSiguiente());
        }

        serieDos.asignarValorInicial(Integer.valueOf(1));

        System.out.println();
        System.out.println("SERIE DOS CON VALOR INICIAL DE 1:");
        for(int i=0; i<4; i++) {
            System.out.println(serieDos.valorSiguiente());
        }

        System.out.println();
        System.out.println("SERIE TRES NORMAL:");
        for(int i=0; i<4; i++) {
            System.out.println(serieTres.valorSiguiente());
        }
    }
}
