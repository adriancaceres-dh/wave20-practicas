package com.bootcamp;

import java.util.*;

public class App {
    public static void main(String[] args) {
        System.out.println("Hola Mundo");

        String miVariable = "algo";
        boolean flag = false;

        if (flag) {
            System.out.println("Hola Mundo");
        } else {
            System.out.println("falso");
        }

        System.out.println("============================");

        System.out.println("linea 1");
        System.out.println("linea 2");
        System.out.println("linea 3");
        System.out.println("linea 4");

        System.out.println("============================");

        for (int i = 0; i <= 3; i++) {
            System.out.println("Linea" + (i + 1));
        }
        System.out.println("============================");

        int e = 0;
        while (e <= 3) {
            System.out.println("Linea" + (e + 1));
            e++;
        }
        System.out.println("============================");
        int j = 0;
        do {
            System.out.println("Linea" + (j + 1));
            j++;
        } while (j <= 3);
        System.out.println("Creando Vector");
        //  int numeroVector [] = new int[5];
        // System.out.println(numeroVector);

        System.out.println("Buscando positivos y negativos");
        int numeros[] = {3, -1, 12, -6, 8, 10};
        int positivos = 0;
        int negativo = 0;

        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] >= 0) {
                positivos++;
            } else {
                negativo++;
            }
        }

        System.out.println(positivos);
        System.out.println(negativo);

        System.out.println("Creando Matriz");
        int[][] numeroMatriz = new int[4][3];
        numeroMatriz[0][1] = 10;

        for (int i = 0; i < numeroMatriz.length; i++) {
            for (int k = 0; k < numeroMatriz[i].length; k++) {
                System.out.println(numeroMatriz[i][k] + " ");
            }
            System.out.println(" ");
        }
        System.out.println("==================================================================");
        System.out.println("Ejercicio Temperaturas y Ciudades");
        String ciudades[] = {"londres", "madrid", "Nueva York", "Buenos Aires", "Asunción", "São Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
        double[][] temperaturas = {{-2, 33}, {-3, 32}, {-8, 27}, {4, 37}, {6, 42}, {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10, 35}};

        double temperaturaMinima = temperaturas[0][0];
        double temperaturaMaxima = temperaturas[0][0];
        String ciudadMinima = ciudades[0];
        String ciudadMaxima = ciudades[0];

        for (int f = 0; f < temperaturas.length; f++) {
            for (int c = 0; c < temperaturas[f].length; c++) {
                if (temperaturas[f][c]<temperaturaMinima){
                    temperaturaMinima=temperaturas[f][c];
                    ciudadMinima=ciudades[f];
                }
                if (temperaturas[f][c]>temperaturaMaxima){
                    temperaturaMaxima=temperaturas[f][c];
                    ciudadMaxima=ciudades[f];
                }
            }

        }
        System.out.println("La ciudad de " + ciudadMinima + " es la ciudad con la temperatura mínima de: " + temperaturaMinima);
        System.out.println("La ciudad de " + ciudadMaxima + " es la ciudad con la temperatura máxima de: " + temperaturaMaxima);

        System.out.println("==================================================================");
        System.out.println("==================================================================");
        System.out.println("Collections");

        //List<Integer> numeros1 = new ArrayList<>();
        //Set<Integer> numeros1 = new TreeSet<>();
        //Set<Integer> numeros1 = new HashSet<>();
        List<Integer> numeros1 = new LinkedList<>();
        numeros1.add(10);
        numeros1.add(10);
        numeros1.add(12);
        numeros1.add(-2);
        numeros1.add(3);
        numeros1.add(13);

        for(int numero : numeros1){
            System.out.println(numero);
        }
        System.out.println("==================================================================");
        System.out.println("==================================================================");
        System.out.println("Mapas");
        System.out.println("Ejemplo 1");
        Map<String, Boolean> mundial = new HashMap<>();
        //estamos en octavos
        mundial.put("Brasil", true);
        mundial.put("mexico", false);
        mundial.put("ESTADOS UNIDOS", true);
        mundial.put("Corea del Sur", true);
        System.out.println(mundial.get("Corea del Sur"));
        System.out.println("Ejemplo 2");

        Map<String, List<String>> vsEEUU = new HashMap<>();

        List<String> partido1 = new ArrayList<>();
        partido1.add("inglaterra");
        partido1.add("gales");
        partido1.add("argentina");
        vsEEUU.put("EEUU", partido1);
        System.out.println(vsEEUU.get("EEUU"));
        System.out.println("==================================================================");
        System.out.println("==================================================================");



    }


}
