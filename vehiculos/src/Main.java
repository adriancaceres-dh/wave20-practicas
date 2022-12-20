import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Garaje garaje = new Garaje(321);
        garaje.agregarVehiculo(new Vehiculo("Fiesta","Ford",1000));
        garaje.agregarVehiculo(new Vehiculo("Focus","Ford",1200));
        garaje.agregarVehiculo(new Vehiculo("Explorer","Ford",2500));
        garaje.agregarVehiculo(new Vehiculo("Fiesta","Ford",1000));
        garaje.agregarVehiculo(new Vehiculo("Uno","Fiat",500));
        garaje.agregarVehiculo(new Vehiculo("Cronos","Fiat",1000));
        garaje.agregarVehiculo(new Vehiculo("Torino","Fiat",1250));
        garaje.agregarVehiculo(new Vehiculo("Aveo","Chevrolet",1250));
        garaje.agregarVehiculo(new Vehiculo("Spint","Chevrolet",2500));
        garaje.agregarVehiculo(new Vehiculo("Corola","Toyota",1200));
        garaje.agregarVehiculo(new Vehiculo("Fortuner","Toyota",3000));
        garaje.agregarVehiculo(new Vehiculo("Logan","Renault",950));


        garaje.getVehiculoList().stream().sorted(Comparator.comparingDouble(Vehiculo::getCosto)).forEach(System.out::println);
        System.out.println("---------------------");
        //garaje.getVehiculoList().stream().sorted((v1,v2) -> v1.compareTo(v2)).forEach(System.out::println);
        //garaje.getVehiculoList().stream().sorted(Vehiculo::compareTo).forEach(System.out::println);
        garaje.getVehiculoList()
                .stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto))
                .forEach(System.out::println);
        System.out.println("---------------------");
        List<Vehiculo> vehiculosBaratos = garaje.getVehiculoList().stream().filter(v -> v.getCosto() < 1000).collect(Collectors.toList());
        System.out.println(vehiculosBaratos);
        System.out.println("---------------------");
        List<Vehiculo> vehiculosCaros = garaje.getVehiculoList().stream().filter(v -> v.getCosto() >= 1000).collect(Collectors.toList());
        System.out.println(vehiculosCaros);
        System.out.println("---------------------");
        Double promedio = (double) Math.round(garaje.getVehiculoList().stream().mapToDouble(Vehiculo::getCosto).average().getAsDouble() * 100) / 100;
        System.out.println(promedio);

    }
}