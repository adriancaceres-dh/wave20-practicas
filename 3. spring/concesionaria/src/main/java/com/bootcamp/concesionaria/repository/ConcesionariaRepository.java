package com.bootcamp.concesionaria.repository;

import com.bootcamp.concesionaria.model.Vehiculo;

import java.util.List;

public interface ConcesionariaRepository {

    List<Vehiculo> getVehiculos();
    void agregarVehiculo(Vehiculo vehiculo);

}
