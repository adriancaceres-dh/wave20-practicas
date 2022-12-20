package com.bootcamp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Garaje garaje = new Garaje(
                1,
                Arrays.asList(
                        new Vehiculo("Ford", "Fiesta", 1000),
                        new Vehiculo("Ford", "Focus", 1200),
                        new Vehiculo("Ford", "Explorer", 2500),
                        new Vehiculo("Fiat", "Uno", 500),
                        new Vehiculo("Fiat", "Cronos", 1000),
                        new Vehiculo("Fiat", "Torino", 1250),
                        new Vehiculo("Chevrolet", "Aveo", 1250),
                        new Vehiculo("Chevrolet", "Spin", 2500),
                        new Vehiculo("Toyota", "Corola", 1200),
                        new Vehiculo("Toyota", "Fortuner", 3000),
                        new Vehiculo("Renault", "Logan", 950)
                )
        );

        List<Vehiculo> vehiculosPorPrecio = garaje.getVehiculos().stream()
                .sorted(Comparator.comparingDouble(Vehiculo::getCosto))
                .collect(Collectors.toList());
        System.out.println("VEHÍCULOS ORDENADOS POR PRECIO:");
        vehiculosPorPrecio.forEach(System.out::println);

        List<Vehiculo> vehiculosPorMarcaPrecio = garaje.getVehiculos().stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto))
                .collect(Collectors.toList());
        System.out.println("\nVEHÍCULOS ORDENADOS POR MARCA Y PRECIO:");
        vehiculosPorMarcaPrecio.forEach(System.out::println);

        List<Vehiculo> vehiculosBaratos = garaje.getVehiculos().stream().filter(v -> v.getCosto() < 1000).collect(Collectors.toList());
        System.out.println("\nVEHÍCULOS BARATOS (MENOS DE 1000):");
        vehiculosBaratos.forEach(System.out::println);

        List<Vehiculo> vehiculosCaros = garaje.getVehiculos().stream().filter(v -> v.getCosto() >= 1000).collect(Collectors.toList());
        System.out.println("\nVEHÍCULOS CAROS (1000 O MÁS):");
        vehiculosCaros.forEach(System.out::println);

        OptionalDouble promedioPrecios = garaje.getVehiculos().stream().mapToDouble(Vehiculo::getCosto).average();
        System.out.println("\nPROMEDIO DE PRECIOS:");
        System.out.println("$" + (promedioPrecios.isPresent() ? promedioPrecios.getAsDouble() : null));
    }
}
