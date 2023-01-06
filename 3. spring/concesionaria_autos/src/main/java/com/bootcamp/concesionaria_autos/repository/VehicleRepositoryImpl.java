package com.bootcamp.concesionaria_autos.repository;

import com.bootcamp.concesionaria_autos.model.Vehicle;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class VehicleRepositoryImpl implements IVehicleRepository {

    private final Set<Vehicle> vehicles;
    private int count;

    public VehicleRepositoryImpl() {
        vehicles = new HashSet<>();
        this.count = 0;
    }

    @Override
    public int createVehicle(Vehicle vehicle) {
        vehicle.setId(++count);
        vehicles.add(vehicle);
        return count;
    }

    @Override
    public Set<Vehicle> getVehicles() {
        return vehicles;
    }

    @Override
    public Set<Vehicle> getVehiclesByManufacturingDate(LocalDate since, LocalDate to) {
        return vehicles.stream().filter(vehicle ->
                (vehicle.getManufacturingDate().isEqual(since) || vehicle.getManufacturingDate().isEqual(to)) ||
                (vehicle.getManufacturingDate().isAfter(since) && vehicle.getManufacturingDate().isBefore(to))
        ).collect(Collectors.toSet());
    }

    @Override
    public Set<Vehicle> getVehiclesByPrice(double since, double to) {
        return vehicles.stream().filter(vehicle -> vehicle.getPrice() >= since && vehicle.getPrice() <= to).collect(Collectors.toSet());
    }

    @Override
    public Optional<Vehicle> getVehicleById(int id) {
        return vehicles.stream().filter(vehicle -> vehicle.getId() == id).findFirst();
    }
}
