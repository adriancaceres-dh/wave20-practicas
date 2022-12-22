package com.bootcamp;

public class Main {
    public static void main(String[] args) {
        final int CANTIDADNAVES = 12;

        //Creo Participantes y Tablero
        int i = 0;
        double[] coordenadas = new double[2 * CANTIDADNAVES];
        for (int j = 0; j < coordenadas.length; j++) {
            coordenadas[j] = Math.round(10 * (40 * Math.random() - 20)) / 10;
        }

        NaveSimple n1 = new NaveSimple("N1", coordenadas[i++], coordenadas[i++]);
        NaveSimple n2 = new NaveSimple("N2", coordenadas[i++], coordenadas[i++]);
        NaveSimple n3 = new NaveSimple("N3", coordenadas[i++], coordenadas[i++]);
        NaveSimple n4 = new NaveSimple("N4", coordenadas[i++], coordenadas[i++]);
        NaveSimple n5 = new NaveSimple("N5", coordenadas[i++], coordenadas[i++]);
        NaveSimple n6 = new NaveSimple("N6", coordenadas[i++], coordenadas[i++]);
        NaveSimple n7 = new NaveSimple("N7", coordenadas[i++], coordenadas[i++]);
        NaveSimple n8 = new NaveSimple("N8", coordenadas[i++], coordenadas[i++]);
        NaveSimple n9 = new NaveSimple("N9", coordenadas[i++], coordenadas[i++]);
        NaveSimple n10 = new NaveSimple("N10", coordenadas[i++], coordenadas[i++]);
        NaveSimple n11 = new NaveSimple("N11", coordenadas[i++], coordenadas[i++]);
        NaveSimple n12 = new NaveSimple("N12", coordenadas[i++], coordenadas[i++]);

        FlotaDeNaves f1 = new FlotaDeNaves("F1", n4, n5);
        FlotaDeNaves f2 = new FlotaDeNaves("F2", n6, n7, n8);
        FlotaDeNaves f3 = new FlotaDeNaves("F3", n9, n10, n11, n12);

        Juego j1 = new Juego(n1, n2, n3, f1, f2, f3);

        System.out.println(j1.toString());

        j1.jugarTurno(5, 5);
    }
}