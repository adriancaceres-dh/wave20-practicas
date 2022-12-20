import Entity.Garaje;
import Entity.Vehiculo;

import java.util.*;

import static java.lang.Double.parseDouble;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Vehiculo v1 = new Vehiculo("Ford", "fiesta", 1000.0);
        Vehiculo v2 = new Vehiculo("Ford", "focus", 1200.0);
        Vehiculo v3 = new Vehiculo("Ford", "explorer", 2500.0);
        Vehiculo v4 = new Vehiculo("Fiat", "uno", 500.0);
        Vehiculo v5 = new Vehiculo("Fiat", "cronos", 1000.0);
        Vehiculo v6 = new Vehiculo("Fiat", "torino", 1250.0);
        Vehiculo v7 = new Vehiculo("Chevrolet", "aveo", 1250.0);
        Vehiculo v8 = new Vehiculo("Chevrolet", "spin", 2500.0);
        Vehiculo v9 = new Vehiculo("Toyota", "corolla", 1200.0);
        Vehiculo v10 = new Vehiculo("Toyota", "fortuner", 3000.0);
        Vehiculo v11 = new Vehiculo("Renault", "logan", 950.0);
        Vehiculo v12 = new Vehiculo("Fiat", "uno", 50.0);
        List<Vehiculo> vehiculos = Arrays.asList(v1,v2,v3,v4,v5,v6,v7,v8,v9,v10,v11,v12);
        vehiculos.stream().sorted((x, y)-> x.getCosto().compareTo(y.getCosto())).forEach(System.out::println);

        System.out.println("Ejercicio 3!");
        vehiculos.stream().sorted((x, y)-> x.getModelo().compareTo(y.getModelo())).forEach(System.out::println);

        System.out.println("Ejercicio 4!");
        vehiculos.stream()
                .sorted(Comparator.comparing(Vehiculo::getModelo)
                .thenComparing(Vehiculo::getCosto))
                .forEach(System.out::println);

        System.out.println("Ejerccio 5, menores a Mil!");
        vehiculos.stream().filter(vehiculo -> vehiculo.getCosto() < 1000).forEach(System.out::println);
        System.out.println("Ejerccio 5, mayores a Mil!");
        vehiculos.stream().filter(vehiculo -> vehiculo.getCosto() >= 1000).forEach(System.out::println);
        System.out.println("Ejerccio 5: Promedio!");

        System.out.println(vehiculos.stream().mapToDouble(vehiculo -> vehiculo.getCosto()).average());


    }
}