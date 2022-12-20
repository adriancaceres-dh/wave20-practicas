import com.bootcamp.clases.Garaje;
import com.bootcamp.clases.Vehiculo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Vehiculo> listaVehiculos = new ArrayList<>();
        //Fords
        Vehiculo ford1 = new Vehiculo("Ford", "Fiesta", 1000);
        Vehiculo ford2 = new Vehiculo("Ford", "Focus", 1200);
        Vehiculo ford3 = new Vehiculo("Ford", "Explorer", 2500);
        listaVehiculos.add(ford1);
        listaVehiculos.add(ford2);
        listaVehiculos.add(ford3);
        //Fiats
        Vehiculo fiat1 = new Vehiculo("Fiat", "Uno", 500);
        Vehiculo fiat2 = new Vehiculo("Fiat", "Cronos", 1000);
        Vehiculo fiat3 = new Vehiculo("Fiat", "Torino", 1250);
        listaVehiculos.add(fiat1);
        listaVehiculos.add(fiat2);
        listaVehiculos.add(fiat3);
        //Chevrolet
        Vehiculo chevy1 = new Vehiculo("Chevrolet", "Aveo", 1250);
        Vehiculo chevy2 = new Vehiculo("Chevrolet", "Spin", 2500);
        listaVehiculos.add(chevy1);
        listaVehiculos.add(chevy2);
        //Toyotas
        Vehiculo toyota1 = new Vehiculo("Toyota", "Corola", 1200);
        Vehiculo toyota2 = new Vehiculo("Toyota", "Fortuner", 3000);
        listaVehiculos.add(toyota1);
        listaVehiculos.add(toyota2);
        //Renaults
        Vehiculo renault1 = new Vehiculo("Renault", "Logan", 950);
        listaVehiculos.add(renault1);

        Garaje garaje = new Garaje(1, listaVehiculos);
        System.out.println("--------Ordenado por Costo-----------");
        garaje.getListaVehiculos().stream().sorted((x, y) -> Double.compare(x.getCosto(), y.getCosto())).forEach(System.out::println);

        System.out.println("--------Ordenado por Marca y Costo-----------");
        garaje.getListaVehiculos().stream().sorted((x, y) -> Double.compare(x.getCosto(), y.getCosto())).sorted((x,y)-> x.getMarca().compareToIgnoreCase(y.getMarca())).forEach(System.out::println);

        System.out.println("--------Lista Vehículos menores a 1000-----------");
        garaje.getListaVehiculos().stream().filter(x -> x.getCosto() < 1000).forEach(System.out::println);

        System.out.println("--------Lista Vehículos mayores o iguales 1000-----------");
        garaje.getListaVehiculos().stream().filter(x -> x.getCosto() >= 1000).sorted((x, y) -> Double.compare(x.getCosto(), y.getCosto())).forEach(System.out::println);

        System.out.println("--------Calcular promedio de los precios-----------");
        System.out.println(garaje.getListaVehiculos().stream().mapToDouble(x -> x.getCosto()).average().getAsDouble());
    }
}
