package com.company;

public class Main {

    public static void main(String[] args) {
        String ciudades[] = {"Londres", "Madrid", "New york", "Buenos aires", "Asuncion", "Sao Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
        int[][] temperaturas = {{-2,33},{-3,32},{-8,27},{4,37},{6,42},{5,43},{0,39},{-7,26},{-1,31},{-10,35}};

        int indiceMenorTemp = 0;
        int indiceMayorTemp = 0;
        int menorTemp = 0;
        int mayorTemp = 0;
        for(int i = 0; i < ciudades.length ; i++){
            if(menorTemp > temperaturas[i][0]){
                menorTemp = temperaturas[i][0];
                indiceMenorTemp = i;
            }
            if(mayorTemp < temperaturas[i][1]){
                mayorTemp = temperaturas[i][1];
                indiceMayorTemp = i;
            }
        }
        System.out.println("La menor temperatura es " + menorTemp + " en la ciudad de " + ciudades[indiceMenorTemp]);
        System.out.println("La mayor temperatura es " + mayorTemp + " en la ciudad de " + ciudades[indiceMayorTemp]);

    }
}
