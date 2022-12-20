package org.example;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    Garaje garaje = new Garaje("El Garaje");
    garaje.agregarVehiculo(new Vehiculo("Ford", "Fiesta", 1000));
    garaje.agregarVehiculo(new Vehiculo("Ford", "Focus", 1200));
    garaje.agregarVehiculo(new Vehiculo("Ford", "Explorer", 2500));
    garaje.agregarVehiculo(new Vehiculo("Chevrolet", "Aveo", 1250));
    garaje.agregarVehiculo(new Vehiculo("Chevrolet", "Spin", 2500));
    garaje.agregarVehiculo(new Vehiculo("Fiat", "Cronos", 1000));
    garaje.agregarVehiculo(new Vehiculo("Fiat", "Uno", 500));
    garaje.agregarVehiculo(new Vehiculo("Fiat", "Torino", 1250));
    garaje.agregarVehiculo(new Vehiculo("Toyota", "Corola", 1200));
    garaje.agregarVehiculo(new Vehiculo("Toyota", "Fortuner", 3000));
    garaje.agregarVehiculo(new Vehiculo("Renault", "Logan", 950));

    garaje.getVehiculos().sort(Comparator.comparing(Vehiculo::getCosto));
    System.out.println("Vehiculos ordenados por costo:");
    garaje.imprimirVehiculos();

    garaje.getVehiculos().sort(Comparator.comparing(Vehiculo::getModelo));
    System.out.println("\nVehiculos ordenados por modelo:");
    garaje.imprimirVehiculos();

    garaje.getVehiculos().sort(Comparator.comparing(Vehiculo::getMarca));
    System.out.println("\nVehiculos ordenados por marca:");
    garaje.imprimirVehiculos();

    garaje.getVehiculos().sort(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto));
    System.out.println("\nVehiculos ordenados por marca y costo:");
    garaje.imprimirVehiculos();

    System.out.println("\nVehiculos filtrados por precio > 1000:");
    garaje.getVehiculos().stream().filter(vehiculo -> vehiculo.getCosto() > 1000).forEach(vehiculo -> System.out.println(vehiculo.getMarca() + " " + vehiculo.getModelo() + " " + vehiculo.getCosto()));

    System.out.println("\nPromedio de precio de vehiculos:");
    garaje.getVehiculos().stream().mapToInt(Vehiculo::getCosto).average().ifPresent(System.out::println);
  }




}