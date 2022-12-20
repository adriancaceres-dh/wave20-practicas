package vehiculos;

import java.util.ArrayList;
import java.util.List;

public class Garaje {
    private long id;
    private List<Vehiculo> vehiculos;

    public Garaje(long id) {
        this.id = id;
        this.vehiculos = new ArrayList<>();
    }

    public void addVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
}
