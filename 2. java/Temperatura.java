package com.bootcamp;

public class Temperatura {
    public static void main(String[] args) {

        String[] ciudades = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "São Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio" };
        int[][] temperaturas = {{-2, 33}, {-3, 32}, {-8, 27}, {4, 37}, {6, 42}, {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10, 35}};

        int temperaturaMaxima = 0;
        int temperaturaMinima = 0;

        for (int i = 0; i < temperaturas.length; i++) {
            if (temperaturas[i][0] < temperaturas[temperaturaMinima][0]) {
                temperaturaMinima = i;
            } else if (temperaturas[i][1] > temperaturas[temperaturaMaxima][1]) {
                temperaturaMaxima = i;
            }
        }

        System.out.println("La menor temperatura la tuvo " + ciudades[temperaturaMinima] + " con " + temperaturas[temperaturaMinima][0] + "°C");
        System.out.println("La mayor temperatura la tuvo " + ciudades[temperaturaMaxima] + " con " + temperaturas[temperaturaMaxima][1] + "°C");
    }
}
