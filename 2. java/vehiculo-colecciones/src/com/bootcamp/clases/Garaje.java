package com.bootcamp.clases;

import java.util.ArrayList;

public class Garaje {
    private int id;
    ArrayList<Vehiculo> vehiculos;

    public Garaje(int id) {
        this.id = id;
        vehiculos = new ArrayList<>();
    }

    public Garaje(int id, ArrayList<Vehiculo>vehiculos) {
        this.id = id;
        this.vehiculos = vehiculos;

    }

    public void agregarVehiculo (Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
}
