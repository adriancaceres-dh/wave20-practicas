import modelo.Garaje;
import modelo.Vehiculo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Vehiculo v1 = new Vehiculo("Fiesta","Ford",1000 );
        Vehiculo v2 = new Vehiculo("Focus","Ford", 1200);
        Vehiculo v3 = new Vehiculo("Explorer","Ford", 2500);
        Vehiculo v4 = new Vehiculo("Uno","Fiat",500 );
        Vehiculo v5 = new Vehiculo("Cronos","Fiat", 1000);
        Vehiculo v6 = new Vehiculo("Torino","Fiat",1250 );
        Vehiculo v7 = new Vehiculo("Aveo","Chevrolet", 1250);
        Vehiculo v8 = new Vehiculo("Spin","Toyota", 2500);
        Vehiculo v9 = new Vehiculo("Corola","Toyota", 1200);
        Vehiculo v10 = new Vehiculo("Fortuner","Toyota", 3000);
        Vehiculo v11 = new Vehiculo("Logan","Renault",950 );
        ArrayList<Vehiculo> menoresDeMil = new ArrayList<>();
        ArrayList<Vehiculo> mayoresOigualesDeMil = new ArrayList<>();
        Garaje g = new Garaje (1,new ArrayList<Vehiculo>(Arrays.asList(v1,v2,v3,v4,v5,v6,v7,v8,v9,v10,v11)));

        g.getVehiculos().stream().sorted(Comparator.comparing(Vehiculo::getCosto)).forEach(System.out::println);

        System.out.println("___________________");
        Comparator<Vehiculo> comparadorMultiple= Comparator.comparing(Vehiculo::getMarca).thenComparing(Comparator.comparing(Vehiculo::getCosto));
        g.getVehiculos().stream().sorted(comparadorMultiple).forEach(System.out::println);
        System.out.println("__________________");
        menoresDeMil = (ArrayList)g.getVehiculos().stream().filter(x->x.getCosto()<1000).collect(Collectors.toList());
        menoresDeMil.stream().forEach(System.out::println);
        System.out.println("_____________________");
        mayoresOigualesDeMil = (ArrayList)g.getVehiculos().stream().filter(x->x.getCosto()>=1000).collect(Collectors.toList());
        mayoresOigualesDeMil.stream().forEach(System.out::println);
        System.out.println("_________________");
        System.out.println(menoresDeMil.stream().mapToInt(a->a.getCosto()).average().getAsDouble());
        System.out.println(mayoresOigualesDeMil.stream().mapToInt(a->a.getCosto()).average().getAsDouble());


    }
}