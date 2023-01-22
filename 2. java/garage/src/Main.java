import com.bootcamp.Garage;
import com.bootcamp.Vehiculo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//ejercicio 2
       // List<Vehiculo> vehiculos = new ArrayList<>();
        Vehiculo v1 = new Vehiculo("Fiesta","Ford",1000.0);
        Vehiculo v2 = new Vehiculo("Focus","Ford",1200.0);
        Vehiculo v3 = new Vehiculo("Explorer","Ford",2500.0);
        Vehiculo v4 = new Vehiculo("Uno","Fiat",500.0);
        Vehiculo v5 = new Vehiculo("Cronos","Fiat",1000.0);
        Vehiculo v6 = new Vehiculo("Torito","Fiat",1250.0);
        Vehiculo v7 = new Vehiculo("Aveo","Chevrolet",1250.0);
        Vehiculo v8 = new Vehiculo("Spin","Chevrolet",2500.0);
        Vehiculo v9 = new Vehiculo("Corola","Toyota",1200.0);
        Vehiculo v10 = new Vehiculo("Forthuner","Toyota",3000.0);
        Vehiculo v11 = new Vehiculo("Logan","Renault",950.0);
        Vehiculo v12 = new Vehiculo("Uno","Fiat",50.0);

        List<Vehiculo> vehicleList = Arrays.asList(v1,v2,v3,v4,v5,v6,v7,v8,v9,v10,v11,v12);
        System.out.println("******************************************************");
        System.out.println("--Ejercicio 2 lista de vehículos: " + vehicleList);

        System.out.println("******************************************************");
        System.out.println("–-Ejercicio 3: precios ordenados por precio de menor a mayor--");
      vehicleList.stream().sorted(Comparator.comparing(Vehiculo::getCosto)).forEach(System.out::println);

        System.out.println("******************************************************");
        System.out.println("--Ejercicio 4: lista ordenada por marca y precio--");
        vehicleList.stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca)
                .thenComparing(Vehiculo::getCosto))
                .forEach(System.out::println);


        System.out.println("******************************************************");
        System.out.println("--Ejercicio 5: promedio de precios: " +

        vehicleList.stream()
                .mapToDouble(vehicle -> vehicle.getCosto())
                .average()
        );

        System.out.println("******************************************************");
        System.out.println("--Precios menores a 1000--");

        vehicleList.stream()
                .filter(v -> v.getCosto() < 1000)
                .forEach(System.out::println);
        System.out.println("--Precios desde 1000");
        vehicleList.stream()
                .filter(v -> v.getCosto() >= 1000)
                .forEach(System.out::println);

    }
}