package ejercicioGenerics;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Vehiculo> vehiculos = new ArrayList<>();

        vehiculos.add(new Vehiculo("Fiesta","Ford",1000));
        vehiculos.add(new Vehiculo("Focus","Ford",1200));
        vehiculos.add(new Vehiculo("Explorer","Ford",2500));
        vehiculos.add(new Vehiculo("Uno","Fiat",500));
        vehiculos.add(new Vehiculo("Cronos","Fiat",1000));
        vehiculos.add(new Vehiculo("Torino","Fiat",1250));
        vehiculos.add(new Vehiculo("Aveo","Chevrolet",1250));
        vehiculos.add(new Vehiculo("Spin","Chevrolet",2500));
        vehiculos.add(new Vehiculo("Corola","Toyota",1200));
        vehiculos.add(new Vehiculo("Fortuner","Toyota",3000));
        vehiculos.add(new Vehiculo("Logan","Renault",950));

        Garaje garaje = new Garaje(1,vehiculos);
        List<Vehiculo> vehiculoOrdenados = garaje.getVehiculoList();


        System.out.println("----lista de vehículos ordenados por precio de menor a mayor----");
        vehiculoOrdenados.stream().sorted(Comparator.comparing(vehiculo -> vehiculo.getCosto())).collect(Collectors.toList()).forEach(v -> System.out.println(v.getCosto()));
        System.out.println("------------");
        System.out.println("----lista ordenada por marca y a su vez por precio----");
        vehiculoOrdenados.stream().sorted((a,b) -> a.getMarca().compareTo(b.getMarca())).forEach(v -> System.out.println(v.getMarca() + " " + v.getCosto()));
        System.out.println("------------");
        System.out.println("---Ejercicio 5-----");
        System.out.println("------------");
        System.out.println("extraer una lista de vehículos con precio no mayor a 1000");
        vehiculoOrdenados.stream().filter(vehiculo -> vehiculo.getCosto() < 1000).forEach(v -> System.out.println(v.getModelo()));
        System.out.println("------------");
        System.out.println("luego otra con precios mayor o igual 1000");
        vehiculoOrdenados.stream().filter(vehiculo -> vehiculo.getCosto() >= 1000).forEach(v -> System.out.println(v.getModelo()));
        System.out.println("------------");
        System.out.println("obtén el promedio total de precios de toda la lista de vehículos");
        int promedioTotal = vehiculoOrdenados.stream().collect(Collectors.summingInt(Vehiculo::getCosto));
        System.out.println(promedioTotal);

    }
}
