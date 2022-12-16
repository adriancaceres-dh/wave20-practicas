package com.bootcamp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        List<String> listP = new ArrayList<String>();
        listP.add("1234");
        listP.add("nathalia");
        listP.add("montero");
        listP.add("22");
        listP.add("321");
        listP.add("780");
        listP.add("o+");
        List<String> listPC = new ArrayList<String>(listP);
        List<String> listPC3 = new ArrayList<String>(listP);

        List<String> listP2 = new ArrayList<String>();
        listP2.add("24553");
        listP2.add("fredy");
        listP2.add("virguez");
        listP2.add("16");
        listP2.add("345");
        listP2.add("865");
        listP2.add("o+");
        List<String> listP2C = new ArrayList<String>(listP2);

        Map<Integer, List<String>> mapCChico = new HashMap<>();
        mapCChico.put(1, listP);
        mapCChico.put(2, listP2C);
        mapCChico.put(3, listP2);
        Map<Integer, List<String>> mapCMedio = new HashMap<>();
        mapCMedio.put(1, listPC);
        mapCMedio.put(2, listP2C);
        Map<Integer, List<String>> mapCAvanzado = new HashMap<>();
        mapCAvanzado.put(1, listPC3);

        Map<String, Map<Integer, List<String>>> mapMaps = new HashMap<>();
        mapMaps.put("Carrera de Circuito Corto", mapCChico);
        mapMaps.put("Carrera de Circuito Medio", mapCMedio);
        mapMaps.put("Carrera de Circuito Avanzado", mapCAvanzado);
        int idCarrera = 0;
        for (Map.Entry<String, Map<Integer, List<String>>> entryM : mapMaps.entrySet()) {
            Map<Integer, List<String>> map = entryM.getValue();
            if (entryM.getKey().equals("Carrera de Circuito Corto")) {
                idCarrera = 1;
            } else if (entryM.getKey().equals("Carrera de Circuito Medio")) {
                idCarrera = 2;
            } else {
                idCarrera = 3;
            }
            System.out.println(entryM.getKey());
            for (Map.Entry<Integer, List<String>> entry : map.entrySet()) {
                List<String> valores1 = entry.getValue();
                int key = entry.getKey();
                int edad = Integer.parseInt(valores1.get(3));
                if (edad < 18 && idCarrera == 1) {
                    valores1.add("1300");
                } else if (edad > 18 && idCarrera == 1) {
                    valores1.add("1500");
                } else if (edad < 18 && idCarrera == 2) {
                    valores1.add("2000");
                } else if (edad > 18 && idCarrera == 2) {
                    valores1.add("2300");
                } else if (edad > 18 && idCarrera == 3) {
                    valores1.add("2800");
                }
                System.out.print(key + " ");
                System.out.println(valores1);
            }
        }
        mapCChico.remove(2);
        System.out.println();
        System.out.println("Borrando ----------------");
        System.out.println("Circuito Chico");
        for (Map.Entry<Integer, List<String>> entry : mapCChico.entrySet()) {
            List<String> valores1 = entry.getValue();
            int key = entry.getKey();
            System.out.println(key + " " + valores1);
        }
    }
}