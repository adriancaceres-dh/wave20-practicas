package com.bootcamp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {

        Vehiculo v1 = new Vehiculo("Ford","fiesta",100.0);
        Vehiculo v2 = new Vehiculo("Fiat","Cronos",1250.0);
        Vehiculo v3 = new Vehiculo("Chevrolet","Aveo",2250.0);

        List<Vehiculo> vehiculos = Arrays.asList(v1,v2,v3);

        System.out.println("-----------Ordenar------------");
        vehiculos.stream().sorted((x,y)-> x.getCosto().compareTo(y.getCosto())).forEach(System.out::println);

        System.out.println("--------Menores que 1000------");
        vehiculos.stream().filter(vehiculo -> vehiculo.getCosto()<1000).forEach(System.out::println);

        System.out.println("-----Mayor o igual que 1000---");
        vehiculos.stream().filter(vehiculo -> vehiculo.getCosto()>=1000).forEach(System.out::println);

        System.out.println("-----Promedio-----");
        double promedio= vehiculos.stream().mapToDouble(vehiculo->vehiculo.getCosto()).average().getAsDouble();
        System.out.println(promedio);


    }
}
