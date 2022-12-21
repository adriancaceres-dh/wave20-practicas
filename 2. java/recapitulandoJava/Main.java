package recapitulandoJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Vehiculo v1 = new Vehiculo("Fiesta","Ford",1000);
        Vehiculo v2 = new Vehiculo("Focus","Ford",1200);
        Vehiculo v3 = new Vehiculo("Explorer","Ford",2500);
        Vehiculo v4 = new Vehiculo("Uno","Fiat",500);
        Vehiculo v5 = new Vehiculo("Cronos","Fiat",1000);
        Vehiculo v6 = new Vehiculo("Torino","Fiat",1250);
        Vehiculo v7 = new Vehiculo("Aveo","Chevrolet",1500);
        Vehiculo v8 = new Vehiculo("Spin","Chevrolet",2500);
        Vehiculo v9 = new Vehiculo("Corola","Toyota",1200);
        Vehiculo v10 = new Vehiculo("Fortuner","Toyota",3000);
        Vehiculo v11 = new Vehiculo("Logan","Renault",950);
//        Vehiculo v = new Vehiculo();

        ArrayList<Vehiculo> listaVehiculos = new ArrayList<>(Arrays.asList(v1,v2,v3,v4,v5,v6,v7,v8,v9,v10,v11));
        Garaje garaje = new Garaje(1,listaVehiculos);

//      Precios de menor a mayor
        System.out.println("Precios menor a mayor\n");
        garaje.getVehiculos().stream().sorted((vehiculo1,vehiculo2)-> vehiculo1.costo.compareTo(vehiculo2.costo)).forEach(System.out::println);

//      Precios por marca de menor a mayor
        System.out.println("\nPrecios por marca y por precio\n");
        Comparator<Vehiculo> comparador = Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto);
        garaje.getVehiculos().stream().sorted(comparador).forEach(System.out::println);

//      Precios mayores y menores a 1000 y promedio
        System.out.println("\nPrecios menores a 1000");
        garaje.getVehiculos().stream().filter(p->p.costo<1000).forEach(System.out::println);

        System.out.println("\nPrecios mayores a 1000");
        garaje.getVehiculos().stream().filter(p->p.costo>=1000).forEach(System.out::println);

        System.out.println("\nPromedio");
        System.out.println(garaje.getVehiculos().stream().mapToInt(p->p.costo).average().getAsDouble());
    }
}
