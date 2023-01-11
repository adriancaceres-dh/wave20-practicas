package com.bootcamp;


public class App
{
    public static void main(String[] args) {

        String[] vector = {"Londres","Madrid","NY","Buenos Aires","Asuncion","Sao Paulo", "Lima","Santiago", "Lisboa","Tokio"};
        int[][] matriz = {
                {-2,33},
                {-3,32},
                {-8,27},
                {4,37},
                {6,42},
                {5,43},
                {0,39},
                {-7,26},
                {-1,31},
                {-10,35}

        };


        // fila es el indice del vector y columna la temperatura ,la fila 0 es la temperatura maxima y la 1 la minima
        int[][] temperaturas = new int[2][2];

        for(int i = 0;i<vector.length;i++){
            for(int j=0;j<matriz[i].length;j++){
                if(matriz[i][j] > temperaturas[0][1]){
                    temperaturas[0][0] = i;
                    temperaturas[0][1] = matriz[i][j];
                }
                if(matriz[i][j] < temperaturas[1][1]){
                    temperaturas[1][0] = i;
                    temperaturas[1][1] = matriz[i][j];
                }
            }
        }
        System.out.println("La temperatura mas alta fue de "+temperaturas[0][1] + " en la ciudad de "+vector[temperaturas[0][0]]);

        System.out.println("La temperatura mas baja fue de "+temperaturas[1][1] + " en la ciudad de "+vector[temperaturas[1][0]]);



    }
}
