package com.bootcamp;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String args[]){
        List<Vehiculo> vehiculos = Arrays.asList(
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
                new Vehiculo("Renault", "Logan", 950));

        Garaje garaje = new Garaje(1, vehiculos);


        // Se obtienen los datos solicitados
        List<Vehiculo> vehiculosOrdenadosPorPrecio = garaje.getVehiculos().stream().sorted((x,y) -> x.getCosto().compareTo(y.getCosto())).collect(Collectors.toList());

        List<Vehiculo> vehiculosOrdenadosPorMarcaYPrecio = garaje.getVehiculos().stream().sorted((x,y) -> x.getCosto().compareTo(y.getCosto()))
                 .sorted((x,y) -> x.getMarca().compareTo(y.getMarca())).collect(Collectors.toList());

        List<Vehiculo> conPrecioNoMayorA1000 = garaje.getVehiculos().stream().filter(v -> v.getCosto() <= 1000).collect(Collectors.toList());

        List<Vehiculo> conPrecioMayorOIgualA1000= garaje.getVehiculos().stream().filter(v -> v.getCosto() >= 1000).collect(Collectors.toList());

        OptionalDouble promedio = garaje.getVehiculos().stream().mapToDouble(v -> v.getCosto()).average();


        // Se imprimen los datos recolectados
        System.out.println("Vehiculos ordenados por precio:");
        vehiculosOrdenadosPorPrecio.stream().forEach((v)-> System.out.println(v));
        System.out.println();
        System.out.println();
        System.out.println("Vehiculos ordenador por Marca y precio:");
        vehiculosOrdenadosPorMarcaYPrecio.stream().forEach((v) -> System.out.println(v));

        System.out.println();
        System.out.println("Vehiculos con precio no mayor a 100:");
        conPrecioNoMayorA1000.stream().forEach((v)-> System.out.println(v));
        System.out.println();
        System.out.println("Vehiculos con precio mayor o igual a 100:");
        conPrecioMayorOIgualA1000.stream().forEach((v)-> System.out.println(v));

        System.out.println();
        System.out.println("Promedio del costo de los vehiculos: " + promedio.getAsDouble());

    }
}
