package com.bootcamp;

public class Temperaturas {

    public static void main(String[] args) {

        String[] ciudades = {"Londres","Madrid","Nueva York","Buenos Aires","Asuncion","Sao Paulo","Lima","Santiago de Chile","Lisboa","Tokio"};
        int[][] temperaturas = {{-2,33},{-3,32},{-8,27},{4,37},{6,42},{5,43},{0,39},{-7,26},{-1,31},{-10,35}};
        int menorTemp = temperaturas[0][0];
        int filaMenorTemp = 0;
        int mayorTemp = temperaturas[0][1];
        int filaMayorTemp = 0;

        for (int i = 0; i < temperaturas.length; i++){
            filaMenorTemp = temperaturas[i][0] < menorTemp ? i : filaMenorTemp;
            menorTemp = temperaturas[i][0] < menorTemp ? temperaturas[i][0] : menorTemp;
            filaMayorTemp = temperaturas[i][1] > mayorTemp ? i : filaMayorTemp;
            mayorTemp = temperaturas[i][1] > mayorTemp ? temperaturas[i][1] : mayorTemp;
        }

        System.out.println("La mayor temperatura la tuvo "+ciudades[filaMayorTemp]+", con "+mayorTemp+"ºC");
        System.out.println("La menor temperatura la tuvo "+ciudades[filaMenorTemp]+", con "+menorTemp+"ºC");
    }
}
