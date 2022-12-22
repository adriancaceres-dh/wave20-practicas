package com.bootcamp;

import java.util.ArrayList;
import java.util.List;

public class Garaje {
    private Long id;
    private List<Vehiculo> vehiculos = new ArrayList<>();

    public Garaje(Long id, List<Vehiculo> vehiculos) {
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
