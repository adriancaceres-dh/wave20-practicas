package com.bootcamp;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //---------------------------------------EJERCICIO 2---------------------------------------
        Garage garage1 = new Garage("garage1");

        garage1.addVehiculo(new Vehicle("Toyota","Fortuner",3000));
        garage1.addVehiculo(new Vehicle("Fiat","Uno",500));
        garage1.addVehiculo(new Vehicle("Fiat","Cronos",1000));
        garage1.addVehiculo(new Vehicle("Chevrolet","Aveo",1250));
        garage1.addVehiculo(new Vehicle("Ford","Fiesta",1000));
        garage1.addVehiculo(new Vehicle("Chevrolet","Spin",2500));
        garage1.addVehiculo(new Vehicle("Ford","Focus",1200));
        garage1.addVehiculo(new Vehicle("Ford","Explorer",2500));
        garage1.addVehiculo(new Vehicle("Renault","Logan",950));
        garage1.addVehiculo(new Vehicle("Toyota","Corola",1200));
        garage1.addVehiculo(new Vehicle("Fiat","Torino",1250));


        //---------------------------------------EJERCICIO 3---------------------------------------
        List<Vehicle> sortedByPrice = garage1.getVehicles().stream()
                .sorted(Comparator.comparingInt(Vehicle::getPrice)).collect(Collectors.toList());

        System.out.println("---------------Vehículos ordenados por precio---------------");
        for (Vehicle v : sortedByPrice) {
            System.out.println(v.toString());
        }
        System.out.println("------------------------------------------------------------");

        //---------------------------------------EJERCICIO 4---------------------------------------
        List<Vehicle> sortedByPriceAndBrand = garage1.getVehicles().stream()
                .sorted(Comparator.comparingDouble(Vehicle::getPrice))
                .sorted((x, y) -> x.getBrand().compareToIgnoreCase(y.getBrand())).collect(Collectors.toList());

        System.out.println("\n-----------Vehículos ordenados por marca y precio-----------");
        for (Vehicle v : sortedByPriceAndBrand) {
            System.out.println(v.toString());
        }
        System.out.println("------------------------------------------------------------");

        //---------------------------------------EJERCICIO 5---------------------------------------
        List<Vehicle> priceNotMayThan1000 = garage1.getVehicles().stream()
                .filter(v -> v.getPrice() < 1000)
                .sorted(Comparator.comparingInt(Vehicle::getPrice)).collect(Collectors.toList());

        System.out.println("\n------------Vehículos con precio no mayor a 1000------------");
        for (Vehicle v : priceNotMayThan1000) {
            System.out.println(v.toString());
        }
        System.out.println("------------------------------------------------------------");

        List<Vehicle> priceNotMayOrEqualThan1000 = garage1.getVehicles().stream()
                .filter(v -> v.getPrice() <= 1000)
                .sorted(Comparator.comparingInt(Vehicle::getPrice)).collect(Collectors.toList());

        System.out.println("\n--------Vehículos con precio no mayor o igual a 1000--------");
        for (Vehicle v : priceNotMayOrEqualThan1000) {
            System.out.println(v.toString());
        }
        System.out.println("------------------------------------------------------------");

        AtomicReference<Double> sumPrice = new AtomicReference<>((double) 0);
        garage1.getVehicles().forEach(v -> sumPrice.updateAndGet(v1 -> (double) (v1 + v.getPrice())));
        double countVehicles = garage1.getVehicles().size();
        double averagePrice = sumPrice.get() / countVehicles;
        System.out.println("\n--------------Precio promedio de los Vehiculos--------------");
        System.out.printf("$ %6.2f%n", averagePrice);
        System.out.println("------------------------------------------------------------");



    }
}
