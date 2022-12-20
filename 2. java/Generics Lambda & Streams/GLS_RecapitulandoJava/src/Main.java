import java.util.Comparator;

public class Main {
    private static Garage Garage = new Garage();
    public static void main(String[] args) {

        Garage.addVehiculo(new Vehiculo("Fiesta","Ford",1000));
        Garage.addVehiculo(new Vehiculo("Focus","Ford",1200));
        Garage.addVehiculo(new Vehiculo("Explorer","Ford",2500));
        Garage.addVehiculo(new Vehiculo("Uno","Fiat",500));
        Garage.addVehiculo(new Vehiculo("Cronos","Fiat",1000));
        Garage.addVehiculo(new Vehiculo("Torino","Fiat",1250));
        Garage.addVehiculo(new Vehiculo("Aveo","Chevrolet",1000));
        Garage.addVehiculo(new Vehiculo("Spin","Chevrolet",2500));
        Garage.addVehiculo(new Vehiculo("Corola","Toyota",1200));
        Garage.addVehiculo(new Vehiculo("Fortuner","Chevrolet",3000));
        Garage.addVehiculo(new Vehiculo("Renault","Logan",850));


        System.out.println("Lista ordenada por precio de menor a mayor");
        Garage.sortVehiculos((v1, v2) -> Double.compare(v1.getCosto(),v2.getCosto()))
                .stream().forEach(System.out::println);

        System.out.println("----------------------------------------------------");

        System.out.println("Lista ordenada por precio de menor a mayor");
        Garage.sortVehiculos((v1, v2) ->
                {
                    int ordenMarca = v1.getMarca().compareTo(v2.getMarca());
                    if (ordenMarca==0) return Double.compare(v1.getCosto(),v2.getCosto());
                    return ordenMarca;
                })
                .stream().forEach(System.out::println);

        System.out.println("----------------------------------------------------");
    }
}