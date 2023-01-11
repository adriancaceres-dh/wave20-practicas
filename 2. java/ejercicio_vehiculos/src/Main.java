import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main
{
    public static void main(String[] args) {

        // ejercicio 2


        Garaje garaje = new Garaje();
        Vehiculo fiesta = new Vehiculo("Ford","Fiesta",1000);
        Vehiculo focus = new Vehiculo("Ford","Focus",1200);
        Vehiculo explorer = new Vehiculo("Ford","Explorer",2500);
        Vehiculo uno = new Vehiculo("Fiat","Uno",500);
        Vehiculo cronos = new Vehiculo("Fiat","Cronos",1000);
        Vehiculo torino = new Vehiculo("Fiat","Torino",1250);
        Vehiculo aveo = new Vehiculo("Chevrolet","Aveo",1250);
        Vehiculo spin = new Vehiculo("Chevrolet","Spin",2500);
        Vehiculo corola = new Vehiculo("Toyota","Corola",1200);
        Vehiculo fortuner = new Vehiculo("Toyota","Fortuner",3000);
        Vehiculo logan = new Vehiculo("Renault","Logan",950);


        List<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(fiesta);
        vehiculos.add(focus);
        vehiculos.add(explorer);
        vehiculos.add(uno);
        vehiculos.add(cronos);
        vehiculos.add(torino);
        vehiculos.add(aveo);
        vehiculos.add(spin);
        vehiculos.add(corola);
        vehiculos.add(fortuner);
        vehiculos.add(logan);
        garaje.setVehiculos(vehiculos);

        // 3- ordenar por precio menor a mayor

        List<Vehiculo> ordenados = garaje.getVehiculos().stream()
                .sorted((x,y)->Double.compare(x.getCosto(),y.getCosto()))
                .collect(Collectors.toList());

        System.out.println(ordenados.toString());

        // 4- ordenar por marca
        List<Vehiculo> ordenados_marca = garaje.getVehiculos().stream()
                .sorted((x,y)->x.getMarca().compareTo(y.getMarca()))
                .collect(Collectors.toList());

        System.out.println(ordenados_marca.toString());


        // 5 - menor costo y mayor costo
        List<Vehiculo> vehiculos_menor_costo= garaje.getVehiculos().stream()
                .filter((x)->x.getCosto()<1000).collect(Collectors.toList());

        System.out.println(vehiculos_menor_costo.toString());

        List<Vehiculo> vehiculos_mayor_costo= garaje.getVehiculos().stream()
                .filter((x)->x.getCosto()>=1000).collect(Collectors.toList());

        System.out.println(vehiculos_mayor_costo.toString());

        System.out.println("Promedio : ");
        double promedio = garaje.getVehiculos().stream().collect(Collectors.summarizingDouble(v->v.getCosto())).getAverage();
        System.out.println(promedio);
    }
}
