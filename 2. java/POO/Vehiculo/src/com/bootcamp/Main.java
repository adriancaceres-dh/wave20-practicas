package com.bootcamp;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
       /* Garage vehiculo1 = new Garage("Fiesta", "Ford", 1000);
        Garage vehiculo2 = new Garage("Focus", "Ford", 1200);
        Garage vehiculo3 = new Garage("Explorer", "Ford", 2500);
        Garage vehiculo4 = new Garage("Uno", "Fiat", 500);
        Garage vehiculo5 = new Garage("Cronos", "Fiat", 1000);
        Garage vehiculo6 = new Garage("Torino", "Fiat", 1250);
        Garage vehiculo7 = new Garage("Aveo", "Chevrolet", 1250);
        Garage vehiculo8 = new Garage("Spin", "Chevrolet", 2500);
        Garage vehiculo9 = new Garage("Corola", "Toyota", 1200);
        Garage vehiculo10 = new Garage("Fortuner", "Toyota", 3000);
        Garage vehiculo11 = new Garage("Logan", "Renault", 950);
        */

        List<Vehiculo> vehiculos = new ArrayList<>();

        vehiculos.add(new Vehiculo("Fiesta", "Ford", 1000));
        vehiculos.add(new Vehiculo("Focus", "Ford", 1200));
        vehiculos.add(new Vehiculo("Explorer", "Ford", 2500));
        vehiculos.add(new Vehiculo("Uno", "Fiat", 500));
        vehiculos.add(new Vehiculo("Cronos", "Fiat", 1000));
        vehiculos.add(new Vehiculo("Torino", "Fiat", 1250));
        vehiculos.add(new Vehiculo("Aveo", "Chevrolet", 1250));
        vehiculos.add(new Vehiculo("Spin", "Chevrolet", 2500));
        vehiculos.add(new Vehiculo("Corola", "Toyota", 1200));
        vehiculos.add(new Vehiculo("Fortuner", "Toyota", 3000));
        vehiculos.add(new Vehiculo("Logan", "Renault", 950));

        Garage garageDeluxe = new Garage(1, vehiculos);

        List<Vehiculo> listaDeVehiculos = garageDeluxe.getGarage();

        System.out.println("\nLista por precios de menor a mayor: ");
        listaDeVehiculos.stream()
                .sorted(Comparator.comparingDouble(Vehiculo::getCosto))
                .forEach(v-> System.out.println(v.getCosto()));

        System.out.println("\nOrdenados por marca y precio: ");
        List<Vehiculo> vehiculosPorPrecio = listaDeVehiculos.stream().sorted(Comparator.comparingDouble(Vehiculo::getCosto)).collect(Collectors.toList());
        vehiculosPorPrecio.stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca).thenComparingDouble(Vehiculo::getCosto))
                .forEach(v-> System.out.println(v.getMarca() + ":" + v.getCosto()));

        System.out.println("\nAutos baratos (<1000)");
        vehiculosPorPrecio.stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca).thenComparingDouble(Vehiculo::getCosto))
                .filter(v->v.getCosto()<1000)
                .collect(Collectors.toList())
                .forEach(v-> System.out.println(v.getMarca() + ":" + v.getCosto()));

        System.out.println("\nAutos caros (>=1000) ordenados por precio");
        vehiculosPorPrecio.stream()
                .sorted(Comparator.comparing(Vehiculo::getCosto).thenComparing(Vehiculo::getMarca))
                .filter(v->v.getCosto()>=1000)
                .collect(Collectors.toList())
                .forEach(v-> System.out.println(v.getMarca() + ":" + v.getCosto()));

        System.out.println("\nPromedio de precios de autos en Garage: ");
        System.out.println("$" + vehiculosPorPrecio.stream()
                .collect(Collectors.summarizingDouble(Vehiculo::getCosto)).getAverage());

    }
}