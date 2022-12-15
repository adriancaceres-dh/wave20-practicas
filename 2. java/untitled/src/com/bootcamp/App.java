package com.bootcamp;

public class App {
    //preincremento ++j
    //postincremento j++

    public static void main(String[] args) {

    /*int numeros[] = {3, 2, -1, -13, 2};
    int positivos=0;
    int negativos = 0;
        for (int i = 0; i < numeros.length; i++) {

            if(numeros[i]<0){
                negativos++;
            }else{
                positivos++;
            }


        }

        System.out.println("cantidad de positivos = "+ positivos );
        System.out.println("cantidad de negativos = "+ negativos );

     */

       String[] Ciudades = new String[]{"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asuncion", "Sao Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokyo"};
       int[][] Temperaturas = {{-2,33},{-3,32},{-8,27},{4,37},{6,42},{5,43},{0,39},{-7,26},{-1,31},{-10,35}};

       int menorTemperatura = 0;
       int mayorTemperatura = 0;
       int ciudadMayorTemperatura = 0;
       int ciudadMenorTemperatura = 0;


        for (int i = 0; i < Temperaturas.length; i++) {
            for (int j = 0; j < Temperaturas[i].length; j++) {
                if(i == 0 && j ==0){
                    menorTemperatura = Temperaturas[i][j];
                    mayorTemperatura = Temperaturas[i][j];
                }
                if(Temperaturas[i][j]< menorTemperatura){
                    menorTemperatura = Temperaturas[i][j];
                    ciudadMenorTemperatura =i;
                }
                if(Temperaturas[i][j]> mayorTemperatura){
                    mayorTemperatura = Temperaturas[i][j];
                    ciudadMayorTemperatura= i;
                }
            }
        }

        System.out.println("ciudad con mayor temperatura = " + Ciudades[ciudadMayorTemperatura] + ", " + mayorTemperatura + "ª");
        System.out.println("ciudad con menor temperatura = " + Ciudades[ciudadMenorTemperatura] + ", " + menorTemperatura + "ª");



    }


}
