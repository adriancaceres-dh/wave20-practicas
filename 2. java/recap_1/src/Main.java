import vehiculos.Garaje;
import vehiculos.Vehiculo;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Garaje garaje = new Garaje(1);
        garaje.addVehiculo(new Vehiculo("Fiesta", "Ford", 1000));
        garaje.addVehiculo(new Vehiculo("Focus", "Ford", 1200));
        garaje.addVehiculo(new Vehiculo("Explorer", "Ford", 2500));
        garaje.addVehiculo(new Vehiculo("Uno", "Fiat", 500));
        garaje.addVehiculo(new Vehiculo("Cronos", "Fiat", 1000));
        garaje.addVehiculo(new Vehiculo("Torino", "Fiat", 1250));
        garaje.addVehiculo(new Vehiculo("Aveo", "Chevrolet", 1250));
        garaje.addVehiculo(new Vehiculo("Spin", "Chevrolet", 2500));
        garaje.addVehiculo(new Vehiculo("Corola", "Toyota", 1200));
        garaje.addVehiculo(new Vehiculo("Fortuner", "Toyota", 3000));
        garaje.addVehiculo(new Vehiculo("Logan", "Renault", 950));

        garaje.getVehiculos()
                .stream()
                .sorted((v1, v2) -> Double.compare(v1.getCosto(), v2.getCosto()))
                .forEach(System.out::println);

        System.out.println("------------------------");

        garaje.getVehiculos()
                .stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto))
                .forEach(System.out::println);

        System.out.println("------------------------");

        garaje.getVehiculos()
                .stream()
                .filter(v -> v.getCosto() < 1000)
                .forEach(System.out::println);

        System.out.println("------------------------");

        garaje.getVehiculos()
                .stream()
                .filter(v -> v.getCosto() >= 1000)
                .forEach(System.out::println);

        System.out.println("------------------------");

        double promedio = garaje.getVehiculos()
                .stream()
                .mapToDouble(Vehiculo::getCosto)
                .average()
                .getAsDouble();

        System.out.println(promedio);
    }
}