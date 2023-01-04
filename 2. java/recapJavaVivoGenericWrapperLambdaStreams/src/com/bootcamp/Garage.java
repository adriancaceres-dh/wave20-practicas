package com.bootcamp;

import java.util.ArrayList;
import java.util.List;

public class Garage {

    private String id;
    private List<Vehicle> vehicles;

    public Garage(String id) {
        this.id = id;
        this.vehicles = new ArrayList<Vehicle>();
    }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public List<Vehicle> getVehicles() { return vehicles; }

    public void setVehicles(List<Vehicle> vehicles) { this.vehicles = vehicles; }

    public void addVehiculo(Vehicle v) {
        vehicles.add(v);
    }

    @Override
    public String toString() {
        String vehiculosToString = "";
        for (Vehicle vehiculo : vehicles) {
            vehiculosToString = vehiculo.toString() + "\n";
        }
        return vehiculosToString;
    }
}
