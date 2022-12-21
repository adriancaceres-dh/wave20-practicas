import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Vehiculo> vehiculos = new ArrayList<>();

        vehiculos.add(new Vehiculo("Fiesta","Ford", 1000));
        vehiculos.add(new Vehiculo("Focus","Ford", 1200));
        vehiculos.add(new Vehiculo("Explorer","Ford", 2500));
        vehiculos.add(new Vehiculo("Uno","Fiat", 500));
        vehiculos.add(new Vehiculo("Cronos","Fiat", 1000));
        vehiculos.add(new Vehiculo("Torino","Fiat", 1250));
        vehiculos.add(new Vehiculo("Aveo","Chevrolet", 1250));
        vehiculos.add(new Vehiculo("Spin","Chevrolet", 2500));
        vehiculos.add(new Vehiculo("Corolla","Toyota", 1200));
        vehiculos.add(new Vehiculo("Fortuner","Toyota", 3000));
        vehiculos.add(new Vehiculo("Logan","Renault", 950));

        Garage garage = new Garage(1,vehiculos);

        List<Vehiculo> listaDeVehiculos = garage.getVehiculos();

        System.out.println("Ordenados por precio: ");
        listaDeVehiculos.stream().sorted(Comparator.comparingDouble(Vehiculo::getCosto)).forEach(c->System.out.println(c.getMarca() +" "+ c.getModelo() + " : " + c.getCosto()));

        System.out.println(" ");

        System.out.println("Ordenados por precio y marca: ");
        List<Vehiculo> vehiculosPorPrecio = listaDeVehiculos.stream().sorted((x,y)-> (int) (x.getCosto() - y.getCosto())).collect(Collectors.toList());
        vehiculosPorPrecio.stream().sorted(Comparator.comparing(Vehiculo::getMarca)).forEach(c-> System.out.println(c.getMarca() + " : " + c.getCosto()));

        System.out.println("");

        System.out.println("Precio menor a 1000.");
        listaDeVehiculos.stream().filter(x->x.getCosto() < 1000).forEach(c->System.out.println(c.getModelo() + ":" + c.getCosto()));

        System.out.println("");
        System.out.println("Precio mayor o igual a 1000.");
        listaDeVehiculos.stream().filter(x->x.getCosto() >= 1000).forEach(c->System.out.println(c.getModelo() + ":" + c.getCosto()));

        System.out.println("");
        System.out.println("Promedio total de precios. ");
        System.out.println(listaDeVehiculos.stream().collect(Collectors.summarizingDouble(Vehiculo::getCosto)).getAverage());

    }

}