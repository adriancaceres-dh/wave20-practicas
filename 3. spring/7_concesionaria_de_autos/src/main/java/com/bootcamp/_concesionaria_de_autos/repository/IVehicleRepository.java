package com.bootcamp._concesionaria_de_autos.repository;

import com.bootcamp._concesionaria_de_autos.model.Vehicle;

import java.util.List;

public interface IVehicleRepository {

    public List<Vehicle> getAll();
    public boolean add(Vehicle vehicle);
    public Vehicle getByID(Long id);
}
