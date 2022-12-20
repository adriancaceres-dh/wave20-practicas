package com.bootcamp;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Garage garage = new Garage(1);
        List<Vehiculo> vhs = new ArrayList<>();
        vhs.add(new Vehiculo("Ford", "Fiesta", 1000));
        vhs.add(new Vehiculo("Ford", "Focus", 1200));
        vhs.add(new Vehiculo("Ford", "Explorer", 2500));
        vhs.add(new Vehiculo("Fiat", "Uno", 500));
        vhs.add(new Vehiculo("Fiat", "Cronos", 1000));
        vhs.add(new Vehiculo("Fiat", "Torino", 1250));
        vhs.add(new Vehiculo("Chevrolet", "Aveo", 1250));
        vhs.add(new Vehiculo("Chevrolet", "Spin", 2500));
        vhs.add(new Vehiculo("Toyota", "Corola", 1200));
        vhs.add(new Vehiculo("Toyota", "Fortuner", 3000));
        vhs.add(new Vehiculo("Renault", "Logan", 950));

        garage.setVehiculos(vhs);

        garage.ordenarGaragePorPrecio();
        System.out.println("-------");
        garage.ordenarGaragePorMarcaYPrecio();

        System.out.println(garage.promedioCosto());
    }
}