package com.bootcamp;

public class Temperaturas {

    public static void main(String[] args) {

        final String[] ciudades = {
            "Londres",
            "Madrid",
            "Nueva York",
            "Buenos Aires",
            "Asunción",
            "São Paulo",
            "Lima",
            "Santiago de Chile",
            "Lisboa",
            "Tokyo"
        };

        final int[][] temperaturas = {
            {-2, 33},
            {-3, 32},
            {-8, 27},
            {4, 37},
            {6, 42},
            {5, 43},
            {0, 39},
            {-7, 26},
            {-1, 31},
            {-10, 35}
        };

        int indiceMaxTemp = 0, indiceMinTemp = 0;

        for(int i=1; i<temperaturas.length; i++) {
            indiceMinTemp = temperaturas[i][0] < temperaturas[indiceMinTemp][0] ? i : indiceMinTemp;
            indiceMaxTemp = temperaturas[i][1] > temperaturas[indiceMaxTemp][1] ? i : indiceMaxTemp;
        }

        System.out.println("Menor temperatura: " + ciudades[indiceMinTemp] + " -> " + temperaturas[indiceMinTemp][0] + "°C");
        System.out.println("Mayor temperatura: " + ciudades[indiceMaxTemp] + " -> " + temperaturas[indiceMaxTemp][1] + "°C");
    }
}
