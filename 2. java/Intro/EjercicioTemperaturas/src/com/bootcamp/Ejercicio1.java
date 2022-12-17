package com.bootcamp;

public class Ejercicio1 {
    public static void main(String[] args){
        String ciudades[] = {"Londres", "Madrid", "Nueva Jork", "Buenos Aires", "Asunción", "Sao Paulo",
                            "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
        int temperaturas [][] = {
                {-2,33},{-3,32},{-8,27},{4,37},{6,42},
                {5,43},{0,39},{-7,26},{-1,31},{-10,35}};

        int temp_max []= {0,0};
        int temp_min [] = {100,0};

        for(int i = 0; i < temperaturas.length ; i++){

            if(temperaturas[i][0] < temp_min[0]) {
                temp_min[0] = temperaturas[i][0];
                temp_min[1] = i;
            }
            if (temperaturas[i][1] > temp_max[0]){
                temp_max[0] = temperaturas[i][1];
                temp_max[1] = i;
            }
        }
        System.out.println("La temperatura mas alta es de "+ciudades[temp_max[1]]+" con "+ temp_max[0]+"°");
        System.out.println("La temperatura mas baja es de "+ciudades[temp_min[1]]+" con "+ temp_min[0]+"°");

    }
}
