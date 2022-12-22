import com.sun.source.tree.NewArrayTree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Garaje garaje= new Garaje(0, new ArrayList<>());
        garaje.getVehiculos().add(new Vehiculo("Ford", "Fiesta", 1000.0));
        garaje.getVehiculos().add(new Vehiculo("Ford", "Focus", 1200.0));
        garaje.getVehiculos().add(new Vehiculo("Ford", "Explorer", 2500.0));
        garaje.getVehiculos().add(new Vehiculo("Fiat", "Uno", 500.0));
        garaje.getVehiculos().add(new Vehiculo("Fiat", "Cronos", 1000.0));
        garaje.getVehiculos().add(new Vehiculo("Fiat", "Torino", 1250.0));
        garaje.getVehiculos().add(new Vehiculo("Chevrolet", "Aveo", 1250.0));
        garaje.getVehiculos().add(new Vehiculo("Chevrolet", "Spin", 2500.0));
        garaje.getVehiculos().add(new Vehiculo("Toyota", "Corolla", 1200.0));
        garaje.getVehiculos().add(new Vehiculo("Toyota", "Fortuner", 3000.0));
        garaje.getVehiculos().add(new Vehiculo("Renault", "Logan", 950.0));

        garaje.getVehiculos().sort(Comparator.comparing(Vehiculo::getCosto));
        System.out.println( garaje.getVehiculos());
        System.out.println("--------------------------------");
        garaje.getVehiculos().sort(Comparator.comparing(Vehiculo::getMarca).thenComparing( Vehiculo::getCosto));
        System.out.println( garaje.getVehiculos());
        System.out.println("--------------------------------");
        var listaMenorAMil = garaje.getVehiculos().stream().filter(vehiculo-> vehiculo.getCosto()<=1000.0).collect(Collectors.toList());
        System.out.println( listaMenorAMil);
        System.out.println("--------------------------------");
        var listaMayorAMil = garaje.getVehiculos().stream().filter(vehiculo-> vehiculo.getCosto()>=1000.0).collect(Collectors.toList());
        System.out.println( listaMayorAMil);
        System.out.println("--------------------------------");
        double contador =0;
        double promedio = garaje.getVehiculos().stream().mapToDouble(Vehiculo::getCosto).sum();
        System.out.println( "Promedio de precio: "+ promedio/ garaje.getVehiculos().size());
        System.out.println("--------------------------------");
    }
}