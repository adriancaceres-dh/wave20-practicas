import com.bootcamp.Garaje;
import com.bootcamp.Vehiculo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Vehiculo vehiculo1 = new Vehiculo("Fiesta", "Ford", 1000.0);
        Vehiculo vehiculo2 = new Vehiculo("Focus", "Ford", 1200.0);
        Vehiculo vehiculo3 = new Vehiculo("Explorer", "Ford", 2500.0);
        Vehiculo vehiculo4 = new Vehiculo("Uno", "Fiat", 500.0);
        Vehiculo vehiculo5 = new Vehiculo("Cronos", "Fiat", 1000.0);
        Vehiculo vehiculo6 = new Vehiculo("Torino", "Fiat", 1250.0);
        Vehiculo vehiculo7 = new Vehiculo("Aveo", "Chevrolet", 1250.0);
        Vehiculo vehiculo8 = new Vehiculo("Spin", "Chevrolet", 2500.0);
        Vehiculo vehiculo9 = new Vehiculo("Corola", "Toyota", 1200.0);
        Vehiculo vehiculo10 = new Vehiculo("Fortuner", "Toyota", 3000.0);
        Vehiculo vehiculo11 = new Vehiculo("Logan", "Renault", 950.0);

        List<Vehiculo> listaVehiculos = new ArrayList<>();
        listaVehiculos.add(vehiculo1);
        listaVehiculos.add(vehiculo2);
        listaVehiculos.add(vehiculo3);
        listaVehiculos.add(vehiculo4);
        listaVehiculos.add(vehiculo5);
        listaVehiculos.add(vehiculo6);
        listaVehiculos.add(vehiculo7);
        listaVehiculos.add(vehiculo8);
        listaVehiculos.add(vehiculo9);
        listaVehiculos.add(vehiculo10);
        listaVehiculos.add(vehiculo11);

        Garaje garaje = new Garaje(1L, listaVehiculos);

        System.out.println("======= EJERCICIO 3 =======");

        listaVehiculos.stream().sorted(Comparator.comparing(Vehiculo::getCosto))
                .forEach(System.out::println);

        System.out.println("======= EJERCICIO 4 =======");

        listaVehiculos.stream().sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto))
                .forEach(vehiculo -> System.out.println(vehiculo.getMarca() + " " + vehiculo.getModelo() + " " + vehiculo.getCosto()));

        System.out.println("======= EJERCICIO 5 =======");

        listaVehiculos.stream().filter(vehiculo -> vehiculo.getCosto() < 1000.0)
                .sorted(Comparator.comparing(Vehiculo::getCosto))
                .forEach(vehiculo -> System.out.println(vehiculo.getMarca() + " " + vehiculo.getModelo() + " " + vehiculo.getCosto()));

        System.out.println("-------------------------");

        listaVehiculos.stream().filter(vehiculo -> vehiculo.getCosto() >= 1000.0)
                .sorted(Comparator.comparing(Vehiculo::getCosto))
                .forEach(vehiculo -> System.out.println(vehiculo.getMarca() + " " + vehiculo.getModelo() + " " + vehiculo.getCosto()));

        System.out.println("-------------------------");

        System.out.println(Math.round(listaVehiculos.stream().collect(Collectors.summarizingDouble(Vehiculo::getCosto)).getAverage()));

    }
}