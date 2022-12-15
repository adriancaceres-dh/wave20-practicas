package com.bootcamp;

public class App {

    public static void main(String[] args) {

        String[] ciudades = {"Londres", "Madrid", "New york", "Buenos aires", "Asuncion", "Sao Paulo",
                "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
        int[][] temperaturas = {{-2,33},{-3,32},{-8,27},{4,37},{6,42},{5,43},{0,39},{-7,26},{-1,31},{-10,35}};

        int indiceMenorTemp = 0;
        int indiceMayorTemp = 0;

        for(int i = 0; i < ciudades.length ; i++){
            if(temperaturas[indiceMenorTemp][0] > temperaturas[i][0]){
                indiceMenorTemp = i;
            }
            if(temperaturas[indiceMayorTemp][1] < temperaturas[i][1]){
                indiceMayorTemp = i;
            }
        }

        System.out.println("La menor temperatura es " + temperaturas[indiceMenorTemp][0] +
                " en la ciudad de " + ciudades[indiceMenorTemp]);
        System.out.println("La mayor temperatura es " + temperaturas[indiceMayorTemp][1] +
                " en la ciudad de " + ciudades[indiceMayorTemp]);

    }

}
