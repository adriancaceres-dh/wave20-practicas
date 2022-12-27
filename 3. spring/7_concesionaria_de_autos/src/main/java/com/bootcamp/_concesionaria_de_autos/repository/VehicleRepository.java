package com.bootcamp._concesionaria_de_autos.repository;

import com.bootcamp._concesionaria_de_autos.model.Vehicle;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VehicleRepository implements IVehicleRepository{

    private List<Vehicle> vehicleDB;

    public List<Vehicle> getAll(){
        return this.vehicleDB;
    }

    public boolean add(Vehicle vehicle){
        return this.vehicleDB.add(vehicle);
    }

    public Vehicle getByID(Long id){
        return vehicleDB.stream()
                .filter(vehicle -> vehicle.getId()==id)
                .findFirst().orElse(null);
    }



}
