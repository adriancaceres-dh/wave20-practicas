import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class Main {

    public static void main(String[] args) {

        Garaje garaje = new Garaje(321);
        garaje.AgregarVehiculo(new Vehiculo("Fiesta","Ford",1000));
        garaje.AgregarVehiculo(new Vehiculo("Focus","Ford",1200));
        garaje.AgregarVehiculo(new Vehiculo("Explorer","Ford",2500));
        garaje.AgregarVehiculo(new Vehiculo("Fiesta","Ford",1000));
        garaje.AgregarVehiculo(new Vehiculo("Uno","Fiat",500));
        garaje.AgregarVehiculo(new Vehiculo("Cronos","Fiat",1000));
        garaje.AgregarVehiculo(new Vehiculo("Torino","Fiat",1250));
        garaje.AgregarVehiculo(new Vehiculo("Aveo","Chevrolet",1250));
        garaje.AgregarVehiculo(new Vehiculo("Spint","Chevrolet",2500));
        garaje.AgregarVehiculo(new Vehiculo("Corola","Toyota",1200));
        garaje.AgregarVehiculo(new Vehiculo("Fortuner","Toyota",3000));
        garaje.AgregarVehiculo(new Vehiculo("Logan","Renault",950));


        //garaje.getVehiculoList().stream().sorted((v1,v2) -> Double.compare(v1.getCosto(),v2.getCosto())).forEach(System.out::println);
        //garaje.getVehiculoList().stream().sorted((v1,v2) -> v1.compareTo(v2)).forEach(System.out::println);
        //garaje.getVehiculoList().stream().sorted(Vehiculo::compareTo).forEach(System.out::println);



        //Ejercicio 3
        //garaje.getVehiculoList().stream().sorted(Comparator.comparing((Vehiculo::getCosto))).forEach(System.out::println);
        //Ejercicio 4
        /*garaje.getVehiculoList()
                .stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto))
                .forEach(System.out::println);*/
        //Ejercicio 5
        //Directos
        List<Vehiculo> vehiculosBaratos = garaje.getVehiculoList().stream().filter(v -> v.getCosto() < 1000).collect(Collectors.toList());
        //System.out.println(vehiculosBaratos);
        List<Vehiculo> vehiculosCaros = garaje.getVehiculoList().stream().filter(v -> v.getCosto() >= 1000).collect(Collectors.toList());
        //System.out.println(vehiculosCaros);
        //High order function
        List<Vehiculo> baratos = filtrarVehiculos(garaje.getVehiculoList(), v -> v.getCosto() < 1000);
        List<Vehiculo> caros = filtrarVehiculos(garaje.getVehiculoList(), v -> v.getCosto() >= 1000);

        Double promedio = garaje.getVehiculoList().stream().mapToDouble(Vehiculo::getCosto).average().getAsDouble();
        //System.out.println(promedio);

    }

    private static List<Vehiculo> filtrarVehiculos(List<Vehiculo> vehiculos, Predicate<Vehiculo> predicate){
        return vehiculos.stream().filter(predicate).collect(Collectors.toList());
    }
}
