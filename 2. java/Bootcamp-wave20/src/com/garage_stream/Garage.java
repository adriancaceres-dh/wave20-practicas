package com.garage_stream;

import java.util.ArrayList;
import java.util.List;

public class Garage {

    private Long id;
    List<Vehiculo> vehiculos = new ArrayList<>();

    public Garage(Long id, List<Vehiculo> vehiculos) {
        this.id = id;
        this.vehiculos = vehiculos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
}
