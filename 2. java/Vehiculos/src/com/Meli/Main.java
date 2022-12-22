package com.Meli;

import com.Meli.model.Garaje;
import com.Meli.model.Vehiculo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {



    public static void main(String[] args) {
	// write your code here
        Garaje garaje = new Garaje();

        garaje.setVehiculos(List.of(
                new Vehiculo("Ford", "Fiesta", 1000),
                new Vehiculo("Ford", "Focus", 1200),
                new Vehiculo("Ford", "Explorer", 2500),
                new Vehiculo("Fiat", "Uno", 500),
                new Vehiculo("Fiat", "Cronos", 1000),
                new Vehiculo("Fiat", "Torino", 1250),
                new Vehiculo("Chevrolet", "Spin", 2500),
                new Vehiculo("Chevrolet", "Aveo", 1250)
        ));

        List<Vehiculo> sortedList = garaje.getVehiculos().stream()
                .sorted(Comparator.comparingDouble(Vehiculo::getCosto))
                .collect(Collectors.toList());

        List<Vehiculo> filterListMenor = garaje.getVehiculos().stream().filter(vehiculo -> vehiculo.getCosto() < 1000).collect(Collectors.toList());
        List<Vehiculo> filterListMayor = garaje.getVehiculos().stream().filter(vehiculo -> vehiculo.getCosto() >= 1000).collect(Collectors.toList());
        double promedioCostos = garaje.getVehiculos().stream().mapToDouble(Vehiculo::getCosto).average().orElse(0);

        int[] arr = new int[]{12,3,5,21,4,85,6,9,2,1};



        for (int a: Arrays.stream(arr).sorted().toArray()){
            System.out.println(a);
        }



        for (Vehiculo vehiculo:sortedList
             ) {
            System.out.println(vehiculo.getCosto());
        }

        for (Vehiculo vehiculo:filterListMenor
        ) {
            System.out.println(vehiculo.getCosto());
        }

        for (Vehiculo vehiculo:filterListMayor
        ) {
            System.out.println(vehiculo.getCosto());
        }

        System.out.println(promedioCostos);

    }
}
