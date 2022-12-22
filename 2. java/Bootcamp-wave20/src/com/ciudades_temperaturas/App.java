package com.ciudades_temperaturas;

public class App {

    public static void main(String[] args) {
        String[] cities = {"Londres",  "Madrid", "Nueva York", "Buenos Aires", "Asunción",
                "Sao Pablo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
        int[][] temperatures = {{-2,33}, {-3, 32}, {-8,27}, {4, 37}, {6, 42},
                {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10, 35} };

        int min = 0;
        int max = 0;

        for (int i = 0; i < temperatures.length; i++) {
            if (temperatures[i][0] < temperatures[0][0]) {
                temperatures[0][0]= temperatures[i][0];
                min = i;
            }
            if (temperatures[i][1] > temperatures[0][1]) {
                temperatures[0][1]= temperatures[i][1];
                max = i;
            }

        }
        System.out.println("La ciudad que presentó la temperatura mínima fue: "+cities[min]+ " " +
                "con "+temperatures[min][0] + "ºC"
        );
        System.out.println("La ciudad que presentó la temperatura máxima fue: "+cities[max]+ " " +
                "con "+temperatures[max][1] + "ºC"
        );



    }
}
