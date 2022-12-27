package com.bootcamp._concesionaria_de_autos.service;

import com.bootcamp._concesionaria_de_autos.dto.response.VehicleDTO;
import com.bootcamp._concesionaria_de_autos.model.Vehicle;

import java.util.List;

public interface IVehicleService {

    public boolean addVehicle(Vehicle vehicle);
    public List<VehicleDTO> getUsed();
    public List<VehicleDTO> getSinceToDate (String since, String to);
    public List<VehicleDTO> getSinceToPrice (String since, String to);
    public VehicleDTO getVehicleByID(Long id);

}
