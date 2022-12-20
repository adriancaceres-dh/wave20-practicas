package Entity;

import java.util.List;

public class Garaje {
    private int Id;
    private List<Vehiculo> vehiculos;

    public Garaje(int id, List<Vehiculo> vehiculos) {
        Id = id;
        this.vehiculos = vehiculos;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
}
