package com.bootcamp.ejemplo;

public class App {
    public static void main(String[] args) {
        String[] ciudades = {"Londres","Madrid","Nueva York","Buenos Aires",
                            "Asuncion","Sao Paulo","Lima","Santiago de Chile","Lisboa","Tokio"};

        int[][] temperatura = {
                {-2,33},{-3,32},
                {-8,27}, {4, 37},
                {6,42},{5,43},
                {0,39},{-7,26},
                {-1,31},{-10,35}
        } ;
        int[][] minMaxTemp = {{temperatura[0][0], temperatura[0][1]}};

        int[][] indiceCiudades = {{0,0}};

        for(int i = 0; i < temperatura.length; i++ ){
                if (temperatura[i][0] < minMaxTemp[0][0]) {
                    minMaxTemp[0][0] = temperatura[i][0];
                    indiceCiudades[0][0] = i;
                }
                if (temperatura[i][1] > minMaxTemp[0][1]) {
                    minMaxTemp[0][1] = temperatura[i][1];
                    indiceCiudades[0][1] = i;
                }
        }

        System.out.println("la Ciudad con la menor temperatura fue "+ciudades[indiceCiudades[0][0]]+" con "+minMaxTemp[0][0]+" grados");
        System.out.println("la Ciudad con la mayor temperatura fue "+ciudades[indiceCiudades[0][1]]+" con "+minMaxTemp[0][1]+" grados");

    }
}
