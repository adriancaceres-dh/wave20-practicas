package com.bootcamp.clases;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args) {


        ArrayList<Vehiculo> misVehiculos = new ArrayList<>();

        misVehiculos.add(new Vehiculo("Ford", "Fiesta", 1000));
        misVehiculos.add(new Vehiculo("Ford", "Focus", 1200));
        misVehiculos.add(new Vehiculo("Ford", "Explorer", 2500));
        misVehiculos.add(new Vehiculo("Fiat", "Uno", 500));
        misVehiculos.add(new Vehiculo("Fiat", "Cronos", 1000));
        misVehiculos.add(new Vehiculo("Fiat", "Torino", 1250));
        misVehiculos.add(new Vehiculo("Chevrolet", "Aveo", 1250));
        misVehiculos.add(new Vehiculo("Chevrolet", "Spin", 2500));
        misVehiculos.add(new Vehiculo("Toyota", "Corola", 1200));
        misVehiculos.add(new Vehiculo("Toyota", "Fortuner", 3000));
        misVehiculos.add(new Vehiculo("Renault", "Logan", 950));

        Garaje garage = new Garaje(1, misVehiculos);



       // lista de vehículos ordenados por precio de menor a mayor e impreso por pantalla el resultado.
        System.out.println("vehiculos con orden de costo menor a mayor ********");
        misVehiculos.stream()
                .sorted(Comparator.comparing(Vehiculo::getCosto)
                .thenComparing(Vehiculo::getCosto))
                .forEach(System.out::println);// se muestran todos los elementos ordenados


        // lista de vehículos ordenados por marca y costo e impreso por pantalla el resultado.
        System.out.println("vehiculos con orden de marca y costo********");
        misVehiculos.stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca)
                .thenComparing(Vehiculo::getCosto))
                .forEach(System.out::println);// se muestran todos los elementos ordenados


        // Flitro de lista de vehículos con precios < 1000
        List<Vehiculo> vehiculosCostoMenor= misVehiculos
                .stream()
                .filter(vehiculo -> vehiculo.getCosto() < 1000)
                .collect(Collectors.toList());

        // Flitro de lista de vehículos con precios >= 1000
        List<Vehiculo> vehiculosCostoMayor = misVehiculos
                .stream()
                .filter( vehiculo -> vehiculo.getCosto() >= 1000)
                .collect(Collectors.toList());

        System.out.println("*****************");
        System.out.println(vehiculosCostoMenor);

        System.out.println("*****************");
        System.out.println(vehiculosCostoMayor);


        //obtén el promedio total de precios de toda la lista de vehículos.
        double promedio = misVehiculos
                .stream()
                .map(Vehiculo::getCosto)
                .reduce((double) 0, (subtotal, element) -> subtotal + element);

        System.out.println(promedio);


         Optional<Vehiculo> v2 =   misVehiculos.stream()
                 .filter(vehiculo -> vehiculo.getCosto() == 1250)
                 .findFirst();
        System.out.println(v2);


    }

}
