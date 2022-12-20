import com.bootcamp.clases.Garage;
import com.bootcamp.clases.Vehiculo;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Vehiculo v1 = new Vehiculo("Fiesta","Ford",1000);
        Vehiculo v2 = new Vehiculo("Focus","Ford",1200);
        Vehiculo v3 = new Vehiculo("Explorer","Ford",2500);
        Vehiculo v4 = new Vehiculo("Uno","Fiat",500);
        Vehiculo v5 = new Vehiculo("Cronos","Fiat",1000);
        Vehiculo v6 = new Vehiculo("Torino","Fiat",1250);
        Vehiculo v7 = new Vehiculo("Aveo","Chevrolet",1250);
        Vehiculo v8 = new Vehiculo("Spin","Chevrolet",2500);
        Vehiculo v9 = new Vehiculo("Corolla","Toyota",1200);
        Vehiculo v10 = new Vehiculo("Fortunner","Toyota",3000);
        Vehiculo v11 = new Vehiculo("Logan","Renault",950);
    //15400+950
        Vehiculo vehiculos[] = {v1,v2,v3,v4,v5,v6,v7,v8,v9,v10,v11};
        List<Vehiculo> lista = new ArrayList<>(List.of(vehiculos));

        Garage garage = new Garage(1,lista);

        garage.ordenarGaragePorPrecio();
        System.out.println("-------");
        garage.ordenarGaragePorMarcaYPrecio();

        System.out.println(garage.promedioCosto());
    }
}