package com.bootcamp.clases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        System.out.println("vehiculos con orden ********");
        misVehiculos.stream()
                        .sorted(Comparator.comparing(Vehiculo::getCosto)
                        .thenComparing(Vehiculo::getCosto))
                        .forEach(System.out::println);// se muestran todos los elementos ordenados





    }
}
