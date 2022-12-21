package com.bootcamp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Garage garage1 = new Garage("garage1");

        garage1.addVehiculo(new Vehiculo("Toyota","Fortuner",3000));
        garage1.addVehiculo(new Vehiculo("Fiat","Uno",500));
        garage1.addVehiculo(new Vehiculo("Fiat","Cronos",1000));
        garage1.addVehiculo(new Vehiculo("Chevrolet","Aveo",1250));
        garage1.addVehiculo(new Vehiculo("Ford","Fiesta",1000));
        garage1.addVehiculo(new Vehiculo("Chevrolet","Spin",2500));
        garage1.addVehiculo(new Vehiculo("Ford","Focus",1200));
        garage1.addVehiculo(new Vehiculo("Ford","Explorer",2500));
        garage1.addVehiculo(new Vehiculo("Renault","Logan",950));
        garage1.addVehiculo(new Vehiculo("Toyota","Corola",1200));
        garage1.addVehiculo(new Vehiculo("Fiat","Torino",1250));

        //Ejercicio 3. Ordenar vehículos
        List<Vehiculo> ordenadoPorPrecio = garage1.getVehiculos().stream()
                .sorted(Comparator.comparingDouble(v -> v.getCosto())).collect(Collectors.toList());
        List<Vehiculo> ordenadoPorMarca = garage1.getVehiculos().stream()
                .sorted((x, y) -> x.getMarca().compareToIgnoreCase(y.getMarca())).collect(Collectors.toList());

        //Ejercicio 4. Ordenar vehículos por marca y precio
        List<Vehiculo> ordenadoPorMarcayPrecio = garage1.getVehiculos().stream()
                .sorted(Comparator.comparingDouble(v -> v.getCosto()))
                .sorted((x, y) -> x.getMarca().compareToIgnoreCase(y.getMarca())).collect(Collectors.toList());

        //Ejercicio 5. Filtrar vehículos
        List<Vehiculo> precioNoMayorA1000 = garage1.getVehiculos().stream()
                .filter(v -> v.getCosto() <= 1000)
                .sorted(Comparator.comparingDouble(v -> v.getCosto())).collect(Collectors.toList());

        List<Vehiculo> precioNoMenorA1000 = garage1.getVehiculos().stream()
                .filter(v -> v.getCosto() >= 1000)
                .sorted(Comparator.comparingDouble(v -> v.getCosto())).collect(Collectors.toList());

        double promedio = garage1.getVehiculos().stream()
                .mapToDouble(v -> v.getCosto()).average().getAsDouble();

        //IMPRIMIR RESULTADOS
        System.out.println("Vehículos ordenados por precio:");
        System.out.println();
        for (Vehiculo v : ordenadoPorPrecio) {
            System.out.println(v.toString());
        }

        System.out.println();
        System.out.println("Vehículos ordenados por marca:");
        System.out.println();
        for (Vehiculo v : ordenadoPorMarca) {
            System.out.println(v.toString());
        }

        System.out.println();
        System.out.println("Vehículos ordenados por marca y precio:");
        System.out.println();
        for (Vehiculo v : ordenadoPorMarcayPrecio) {
            System.out.println(v.toString());
        }

        System.out.println();
        System.out.println("Vehículos con precio no mayor a $1000");
        System.out.println();
        for (Vehiculo v : precioNoMayorA1000) {
            System.out.println(v.toString());
        }

        System.out.println();
        System.out.println("Vehículos con precio no menor a $1000");
        System.out.println();
        for (Vehiculo v : precioNoMenorA1000) {
            System.out.println(v.toString());
        }

        System.out.println();
        System.out.println(String.format("Promedio de precios: $ %6.2f", promedio));
    }
}