package com.bootcamp;

public class Main {
    public static void main (String[] args) {

        String[] ciudades = {"Lodres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "Sao Paulo", "Lima"
        , "Santiago de Chile", "Lisboa", "Tokio"};

        int[][] temperaturas = {{-2,33},{-3,32},{-8,27},{4,37},{6,42},{5,43},{0,39},{-7,26},{-1,31},{-10,35}};

        String[] ciudadmenor_ciudadmayor = {"Londres", "Londres"};
        int[] menortemp_mayortemp = {-2,33};

        for (int i = 1; i < ciudades.length; i++){
            if(temperaturas[i][0]<menortemp_mayortemp[0]){
                ciudadmenor_ciudadmayor[0] = ciudades[i];
                menortemp_mayortemp[0] = temperaturas[i][0];
            }
            if(temperaturas[i][1]>menortemp_mayortemp[1]){
                ciudadmenor_ciudadmayor[1] = ciudades[i];
                menortemp_mayortemp[1] = temperaturas[i][1];
            }
        }

        System.out.println(ciudadmenor_ciudadmayor[0] + menortemp_mayortemp[0] + ciudadmenor_ciudadmayor[1] +
                menortemp_mayortemp[1]);
    }
}