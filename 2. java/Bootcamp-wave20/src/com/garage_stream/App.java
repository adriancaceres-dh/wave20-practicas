package com.garage_stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        List<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(new Vehiculo("Ford", "Fiesta", 1000D));
        vehiculos.add(new Vehiculo("Ford", "Focus", 1200D));
        vehiculos.add(new Vehiculo("Ford", "Explorer", 2500D));
        vehiculos.add(new Vehiculo("Fiat", "Uno", 500D));
        vehiculos.add(new Vehiculo("Fiat", "Cronos", 1000D));
        vehiculos.add(new Vehiculo("Fiat", "Torino", 1200D));
        vehiculos.add(new Vehiculo("Chevrolet", "Aveo", 1250D));
        vehiculos.add(new Vehiculo("Chevrolet", "Spin", 2500D));
        vehiculos.add(new Vehiculo("Toyota", "Corola", 1200D));
        vehiculos.add(new Vehiculo("Toyota", "Fortunnier", 3000D));
        vehiculos.add(new Vehiculo("Renault", "Logan", 950D));


        //vehiculos.sort((v1, v2)-> (int) (v1.getCosto() - v2.getCosto()));
        //System.out.println(vehiculos);
        Collections.sort(vehiculos, Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto));
        System.out.println(vehiculos);
        List<Vehiculo> vehiculosMenorMil = vehiculos.stream().filter(v1-> v1.getCosto() < 1000D).collect(Collectors.toList());
        System.out.println(vehiculosMenorMil);
        List<Vehiculo> vehiculosMayorOIgualMil = vehiculos.stream().filter(v1-> v1.getCosto() >= 1000D).collect(Collectors.toList());
        System.out.println(vehiculosMayorOIgualMil);
        double suma = vehiculos.stream().mapToDouble(v -> v.getCosto()).sum();
        double promedio = 0;
        try {
            promedio = suma /vehiculos.size();
        } catch (ArithmeticException e) {
            e.getMessage();
        }

        System.out.println("El promedio es de : "+ Math.round(promedio));

    }
}
