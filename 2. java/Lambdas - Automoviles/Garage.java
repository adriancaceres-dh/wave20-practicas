package com.bootcamp;

import java.util.ArrayList;
import java.util.List;

public class Garage {
    private String id;
    private List<Vehiculo> vehiculos;

    public Garage(String id) {
        this.id = id;
        this.vehiculos = new ArrayList<Vehiculo>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public void addVehiculo(Vehiculo v) {
        vehiculos.add(v);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Vehiculo vehiculo : vehiculos) {
            sb.append(vehiculo.toString() + "\n");
        }
        return sb.toString();
    }
}
