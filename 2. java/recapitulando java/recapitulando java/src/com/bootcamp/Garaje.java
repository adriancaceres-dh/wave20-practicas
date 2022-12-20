package com.bootcamp;

import java.util.List;

public class Garaje {

    private int id;
    private List<String> vehiculos;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<String> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public Garaje(int id, List<String> vehiculos) {
        this.id = id;
        this.vehiculos = vehiculos;
    }
}
