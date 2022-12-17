package com.bootcamp;
import java.util.*;

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

        /*
       String[] Ciudades = new String[]{"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asuncion", "Sao Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokyo"};
       int[][] Temperaturas = {{-2,33},{-3,32},{-8,27},{4,37},{6,42},{5,43},{0,39},{-7,26},{-1,31},{-10,35}};

       int menorTemperatura = 0;
       int mayorTemperatura = 0;
       int ciudadMayorTemperatura = 0;
       int ciudadMenorTemperatura = 0;
        double gh = 45857.90;

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
*/
        //Set<Integer> numeros = new TreeSet<>();
        //List<Integer> numeros = new LinkedList<>();
        List<Integer> numeros = new ArrayList<>();
        numeros.add(10);
        numeros.add(10);
        numeros.add(-2);
        numeros.add(30);

        for(int numero : numeros){
            System.out.println(numero);
        }

        //Map<String, Boolean> mundial = new HashMap<>();
        Map<String, Boolean> mundial = new TreeMap<>();

        mundial.put("Brasil", true);
        mundial.put("Argentina", true);
        mundial.put("Colombia", false);

        System.out.println(mundial.get("Argentina"));

        for(Map.Entry<String, Boolean> partidos : mundial.entrySet()){
            System.out.println(partidos.getKey() + " " + partidos.getValue() );
        }

    }


}
