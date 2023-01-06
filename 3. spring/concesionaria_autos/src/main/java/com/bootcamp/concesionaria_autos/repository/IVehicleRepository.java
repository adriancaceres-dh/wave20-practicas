package com.bootcamp.concesionaria_autos.repository;

import com.bootcamp.concesionaria_autos.model.Vehicle;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;

public interface IVehicleRepository {

    int createVehicle(Vehicle vehicle);
    Set<Vehicle> getVehicles();
    Set<Vehicle> getVehiclesByManufacturingDate(LocalDate since, LocalDate to);
    Set<Vehicle> getVehiclesByPrice(double since, double to);
    Optional<Vehicle> getVehicleById(int id);
}
