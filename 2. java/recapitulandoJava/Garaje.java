package recapitulandoJava;

import java.util.List;

public class Garaje {
    int id;
    List<Vehiculo> vehiculos;

    public Garaje(int id, List<Vehiculo> vehiculos) {
        this.id = id;
        this.vehiculos = vehiculos;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public int getId() {
        return id;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }
}
