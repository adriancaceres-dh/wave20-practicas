import java.sql.SQLOutput;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Vehiculo v1 = new Vehiculo("Ford", "Fiesta", 1000);
        Vehiculo v2 = new Vehiculo("Ford", "Focus", 1200);
        Vehiculo v3 = new Vehiculo("Ford", "Explorer", 2500);
        Vehiculo v4 = new Vehiculo("Fiat", "Uno", 500);
        Vehiculo v5 = new Vehiculo("Fiat", "Cronos", 1000);
        Vehiculo v6 = new Vehiculo("Fiat", "Torino", 1250);
        Vehiculo v7 = new Vehiculo("Chevrolet", "Aveo", 1250);
        Vehiculo v8 = new Vehiculo("Chevrolet", "Spin", 2500);
        Vehiculo v9 = new Vehiculo("Toyota", "Corola", 1200);
        Vehiculo v10 = new Vehiculo("Toyota", "Fortuna", 3000);
        Vehiculo v11 = new Vehiculo("Renault", "Logan", 950);

        Garaje G1 = new Garaje(123);

        G1.agregarNuevoVehiculo(v1);
        G1.agregarNuevoVehiculo(v2);
        G1.agregarNuevoVehiculo(v3);
        G1.agregarNuevoVehiculo(v4);
        G1.agregarNuevoVehiculo(v5);
        G1.agregarNuevoVehiculo(v6);
        G1.agregarNuevoVehiculo(v7);
        G1.agregarNuevoVehiculo(v8);
        G1.agregarNuevoVehiculo(v9);
        G1.agregarNuevoVehiculo(v10);
        G1.agregarNuevoVehiculo(v11);

        List<Vehiculo> ordenadoPorPrecio = G1.getVehiculos().stream()
                .sorted(Comparator.comparingInt(Vehiculo::getCosto)
                        .reversed())
                .collect(Collectors.toList());
        ordenadoPorPrecio.forEach(System.out::println);

        System.out.println();
        List<Vehiculo> ordenadoPorPrecioYMarca = G1.getVehiculos().stream()
                .sorted(Comparator.comparingInt(Vehiculo::getCosto)
                        .reversed())
                .sorted((x,y) -> x.getMarca().compareToIgnoreCase(y.getMarca()))
                .collect(Collectors.toList());
        ordenadoPorPrecioYMarca.forEach(System.out::println);

        System.out.println();
        List<Vehiculo> menoresA1000 = G1.getVehiculos().stream().filter(x->x.getCosto()<1000).collect(Collectors.toList());
        List<Vehiculo> mayoresA1000 = G1.getVehiculos().stream().filter(x->x.getCosto()>=1000).collect(Collectors.toList());

        System.out.println("MENORES A 1000");
        menoresA1000.forEach(System.out::println);
        System.out.println("MAYORES A 1000");
        mayoresA1000.forEach(System.out::println);

        System.out.println("PROMEDIO TOTAL");
        int sum = G1.getVehiculos().stream()
                .collect(Collectors.summingInt(Vehiculo::getCosto));
        OptionalDouble sum2 = G1.getVehiculos().stream().mapToDouble(Vehiculo::getCosto).average();
        System.out.println(sum / G1.getVehiculos().stream().count());
        System.out.println(Math.round(Integer));
    }
}