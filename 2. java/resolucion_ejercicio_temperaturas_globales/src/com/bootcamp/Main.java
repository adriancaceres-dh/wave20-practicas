package com.bootcamp;

public class Main {

    public static void main(String[] args) {

        //Inicializa valores
        String vectorCiudades[] = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción",
            "São Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
        double matrizTemperaturas[][] = {{-2, 33}, {-3, 32}, {-8, 27}, {4, 37}, {6, 42}, {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10, 35}};
        double tempMinima, tempMaxima;
        String ciudadMinima, ciudadMaxima;

        //Se utiliza variables auxiliares para guardar las temperaturas y ciudades
        tempMinima = matrizTemperaturas[0][0];
        ciudadMinima = vectorCiudades[0];
        tempMaxima = matrizTemperaturas[0][0];
        ciudadMaxima = vectorCiudades[0];
        //Recorrido para encontrar la temperatura mínima y máxima
        for (int f = 0; f < matrizTemperaturas.length; f++) {
            for (int c = 0; c < matrizTemperaturas[0].length; c++) {

                //Condición para encontrar la temperatura mínima y guardar la ciudad que posea la misma
                if (matrizTemperaturas[f][c]<tempMinima){
                    tempMinima=matrizTemperaturas[f][c];
                    ciudadMinima=vectorCiudades[f];
                }
                //Condición para encontrar la temperatura máxima y guardar la ciudad que posea la misma
                if (matrizTemperaturas[f][c]>tempMaxima){
                    tempMaxima=matrizTemperaturas[f][c];
                    ciudadMaxima=vectorCiudades[f];
                }

            }

        }
        System.out.println("-------------------");
        System.out.println("---INFORME FINAL---");
        System.out.println("-------------------");
        System.out.println("La ciudad de " + ciudadMinima + " es la ciudad con la temperatura mínima de: " + tempMinima);
        System.out.println("La ciudad de " + ciudadMaxima + " es la ciudad con la temperatura máxima de: " + tempMaxima);
        System.out.println("------------------------------------------------------------------------------------------");
    }
}
