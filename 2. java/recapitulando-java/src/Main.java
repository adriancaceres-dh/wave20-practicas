import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> vehiculos = new ArrayList<>();

        vehiculos.add(new Vehiculo("Ford", "Fiesta", 1000));
        vehiculos.add(new Vehiculo("Ford", "Focus", 1200));
        vehiculos.add(new Vehiculo("Ford", "Explorer", 2500));
        vehiculos.add(new Vehiculo("Fiat", "Uno", 1000));
        vehiculos.add(new Vehiculo("Fiat", "Cronos", 1250));
        vehiculos.add(new Vehiculo("Fiat", "Torino", 1250));
        vehiculos.add(new Vehiculo("Chevrolet", "Aveo", 1250));
        vehiculos.add(new Vehiculo("Chevrolet", "Spin", 2500));
        vehiculos.add(new Vehiculo("Toyota", "Corola", 1200));
        vehiculos.add(new Vehiculo("Toyota", "Fortuner", 3000));
        vehiculos.add(new Vehiculo("Renault", "Logan", 950));

        Garage garage = new Garage(0, vehiculos);

        garage.getVehiculos().sort(Comparator.comparing(Vehiculo::getCosto));
        garage.getVehiculos().sort(Comparator.comparing(Vehiculo::getMarca));

        garage.getVehiculos().stream().filter(vehiculo -> vehiculo.getCosto()<1000).collect(Collectors.toList())
                .forEach(vehiculo -> System.out.println(vehiculo.toString()));

        System.out.println();

        garage.getVehiculos().stream().filter(vehiculo -> vehiculo.getCosto()>=1000).collect(Collectors.toList())
                .forEach(vehiculo -> System.out.println(vehiculo.toString()));

        //garage.imprimirVehiculos();

        System.out.println(garage.promedio());

        /*
        garaje.getVehiculos().sort(Comparator.comparing(Vehiculo::getCosto));
    System.out.println("Vehiculos ordenados por costo:");
    garaje.imprimirVehiculos();

    garaje.getVehiculos().sort(Comparator.comparing(Vehiculo::getModelo));
    System.out.println("Vehiculos ordenados por modelo:");
    garaje.imprimirVehiculos();

    garaje.getVehiculos().sort(Comparator.comparing(Vehiculo::getMarca));
    System.out.println("Vehiculos ordenados por marca:");
    garaje.imprimirVehiculos();
         */

        //garaje.getVehiculos().sort(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto));

    }
}