import com.bootcamp.clases.Garage;
import com.bootcamp.clases.Vehiculo;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Garage garage = new Garage(1);
        garage.addVehiculo(new Vehiculo("Fiesta","Ford",1000))
                .addVehiculo(new Vehiculo("Focus","Ford",1200))
                .addVehiculo(new Vehiculo("Explorer","Ford",2500))
                .addVehiculo(new Vehiculo("Uno","Fiat",500))
                .addVehiculo(new Vehiculo("Cronos","Fiat",1000))
                .addVehiculo(new Vehiculo("Torino","Fiat",1250))
                .addVehiculo(new Vehiculo("Aveo","Chevrolet",1250))
                .addVehiculo(new Vehiculo("Spin","Chevrolet",2500))
                .addVehiculo(new Vehiculo("Corolla","Toyota",1200))
                .addVehiculo(new Vehiculo("Fortunner","Toyota",3000))
                .addVehiculo(new Vehiculo("Logan","Renault",950));

        garage.ordenarGaragePorPrecio();
        garage.imprimirGarage();
        System.out.println("----------------");
        garage.ordenarGaragePorMarcaYPrecio();
        garage.imprimirGarage();
        System.out.println("----------------");
        System.out.println(garage.listaPrecioBajo(1000));
        System.out.println("----------------");
        System.out.println(garage.listaPrecioSobre(1000));
        System.out.println("----------------");
        System.out.println(garage.promedioCosto());
    }
}