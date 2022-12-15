package com.bootcamp;

public class Main {
    public static void main(String[] args) {

        String[] cities = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "São Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio" };
        int[][] temperature = {{-2, 33}, {-3, 32}, {-8, 27}, {4, 37}, {6, 42}, {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10, 35}};
        int tempMenor = temperature[0][0];
        int tempMayor = temperature[0][1];
        String cityMenor = "";
        String cityMayor = "";
        for (int i = 1; i < cities.length; i++) {
            if (temperature[i][0] < tempMenor) {
                tempMenor = temperature[i][0];
                cityMenor = cities[i];
            }
            if (temperature[i][1] > tempMayor) {
                tempMayor = temperature[i][1];
                cityMayor = cities[i];
            }
        }
        System.out.println("la menor temperatura la tuvo " + cityMenor + ", con " + tempMenor + "º C.");
        System.out.println("la mayor temperatura la tuvo " + cityMayor + ", con " + tempMayor + "º C.");
    }
}