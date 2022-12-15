package com.bootcamp;

public class App {

    public static void main(String[] args) {

        String [] ciudades = {"Londres","Madrid","Nueva York","Buenos Aires","Asuncion","Sao Paulo","Lima","Santiago de Chile","Lisboa","Tokio"};
        int[][] temperaturas = {
                {-2, 33},
                {-3, 32},
                {-8, 27},
                {-4, 37},
                {6, 42},
                {5, 43},
                {0, 39},
                {-7, 26},
                {-1, 31},
                {-10, 35}
        };
        // guarda las temperaturas en la posicion 0 y el indice de la ciudad en la posicion 1
        int [] minima = {9999,-1};
        int [] maxima = {-9999,-1};
        
        for (int i = 0; i < temperaturas.length; i++) {
            for (int j = 0; j < temperaturas[1].length; j++) {
                if (temperaturas[i][j] < minima[0]) {
                    minima[0] = temperaturas[i][j];
                    minima[1] = i;
                }
                if (temperaturas[i][j] > maxima[0]) {
                    maxima[0] = temperaturas[i][j];
                    maxima[1] = i;
                }
            }
        }
        System.out.println("La minima temperatura es "+minima[0]+" en la ciudad de "+ciudades[minima[1]]);
        System.out.println("La maxima temperatura es "+maxima[0]+" en la ciudad de "+ciudades[maxima[1]]);
    }

}
