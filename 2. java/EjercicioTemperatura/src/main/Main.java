package main;

public class Main {

    public static void main(String[] args) {

        String[] ciudades = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asuncion", "Sao Paulo", "Lima",  "Santiago", "Lisboa", "Tokio"};
        int[][] temperaturas = {{-2,33},{-3,32},{-8,23},{4,37},{6,42},{5,43},{0,39},{-7,26},{-1,31},{-10,35}};

        int tempMin = temperaturas[0][0];
        int tempMax = temperaturas[0][1];
        String ciudadMin = ciudades[0];
        String ciudadMax = ciudades[0];

        for (int i=1; i< temperaturas.length;i++){
            if(temperaturas[i][0] < tempMin){
                tempMin = temperaturas[i][0];
                ciudadMin = ciudades[i];
            }
            if(temperaturas[i][1] > tempMax){
                tempMax = temperaturas[i][1];
                ciudadMax = ciudades[i];
            }
        }

        System.out.println("La ciudad con la temperatura minima es " + ciudadMin + " con " + tempMin);
        System.out.println("La ciudad con la temperatura maxima es " + ciudadMax + " con " + tempMax);
        }

}
