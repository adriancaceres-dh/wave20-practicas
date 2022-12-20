package com.bootcamp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        //Ejercicio 2

        List<Vehiculo> listaVehiculos= new ArrayList<>(){{
                add(new Vehiculo("Ford","Fiesta",1000));
                add(new Vehiculo("Ford","Focus",1200));
                add(new Vehiculo("Ford","Explorer",2500));
                add(new Vehiculo("Fiat","Uno",500));
                add(new Vehiculo("Fiat","Cronos",1000));
                add(new Vehiculo("Fiat","Torino",1250));
                add(new Vehiculo("Chevrolet","Aveo", 1250));
                add(new Vehiculo("Chevrolet","Spin",2500));
                add(new Vehiculo("Toyota","Corola",1200));
                add(new Vehiculo("Toyota","Fortuner",3000));
                add(new Vehiculo("Renault","Logan",950));

        }};

        //Ejercicio 3

        listaVehiculos.stream()
                .sorted(Comparator.comparingDouble(Vehiculo::getCosto))
                .forEach(vehiculo->System.out.println(vehiculo.getModelo()));

        //Ejercicio 4

        listaVehiculos.stream()
                .sorted(Comparator.comparingDouble(Vehiculo::getCosto))
                .sorted(Comparator.comparing(Vehiculo::getMarca))
                .forEach(vehiculo->System.out.println(vehiculo.toString()));

        //Ejericio 5

        List<Vehiculo>listaVehiculos2 = listaVehiculos.stream()
                .filter(vehiculo -> vehiculo.getCosto()<=1000)
                .collect(Collectors.toList());

        List<Vehiculo>listaVehiculos3 = listaVehiculos.stream()
                .filter(vehiculo -> vehiculo.getCosto()>=1000)
                .collect(Collectors.toList());

        double promedio = listaVehiculos.stream()
                .mapToDouble(Vehiculo::getCosto)
                .average().orElse(0);

    }
}
