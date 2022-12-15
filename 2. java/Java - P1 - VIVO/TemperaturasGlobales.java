package com.bootcamp;

public class TemperaturasGlobales {

    public static void main(String[] args) {
        String[] ciudades = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "Sao Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
        int[][] temperaturas = {{-2, 33}, {-3, 32}, {-8, 27}, {4, 37}, {6, 42}, {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10, 35}};

        int posMenorTemp = 0;
        int posMayorTemp = 0;

        for (int i = 0; i < temperaturas.length; i++) {
            if (temperaturas[i][0] < temperaturas[posMenorTemp][0]) {
                posMenorTemp = i;
            }
            if (temperaturas[i][1] > temperaturas[posMayorTemp][1]) {
                posMayorTemp = i;
            }
        }
        System.out.println("La menor temperatura la tuvo " + ciudades[posMenorTemp] + ", con " + temperaturas[posMenorTemp][0] + " ºC.");
        System.out.println("La mayor temperatura la tuvo " + ciudades[posMayorTemp] + ", con " + temperaturas[posMayorTemp][1] + " ºC.");
    }
}
