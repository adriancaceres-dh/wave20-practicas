import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        //EJ 1 y EJ 2
        List<Vehiculo> vehiculos = Arrays.asList(
                new Vehiculo("Fiesta","Ford",1000),
                new Vehiculo("Focus","Ford",1200),
                new Vehiculo("Explorer","Ford",2500),
                new Vehiculo("Uno","Fiat",500),
                new Vehiculo("Cronos","Fiat",1000),
                new Vehiculo("Torino","Fiat",1000),
                new Vehiculo("Aveo","Chevrolet",1250)
        );

        Garaje garaje = new Garaje(1, vehiculos);

        //EJ 3

        List<Vehiculo> vehiculosOrdenadosXCosto = vehiculos
                .stream()
                .sorted(Comparator.comparingDouble(Vehiculo::getCosto))
                .collect(Collectors.toList());

        System.out.println(vehiculosOrdenadosXCosto);

        //EJ 4

        vehiculos
                .sort(Comparator
                        .comparing((Vehiculo v)->v.getCosto())
                        .thenComparing((Vehiculo v)->v.getMarca()));

        //EJ 5
        List<Vehiculo> vehiculosMenorQue1000= vehiculos
                .stream()
                .filter(vehiculo -> vehiculo.getCosto()<1000)
                .collect(Collectors.toList());

        List<Vehiculo> vehiculosMayorQue1000= vehiculos
                .stream()
                .filter(vehiculo -> vehiculo.getCosto()>=1000)
                .collect(Collectors.toList());

        double promedio = vehiculos
                .stream()
                .mapToDouble(Vehiculo::getCosto)
                .average()
                .getAsDouble();

    }
}
