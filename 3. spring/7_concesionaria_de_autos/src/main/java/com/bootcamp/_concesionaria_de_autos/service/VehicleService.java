package com.bootcamp._concesionaria_de_autos.service;

import com.bootcamp._concesionaria_de_autos.dto.response.VehicleDTO;
import com.bootcamp._concesionaria_de_autos.model.Vehicle;
import com.bootcamp._concesionaria_de_autos.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class VehicleService {
    @Autowired
    VehicleRepository vehicleRepository;

    public boolean addVehicle(Vehicle vehicle){
        return vehicleRepository.add(vehicle);
    }
    public List<VehicleDTO> getUsed(){
        return vehicleRepository.getAll().stream()
                .filter(vehicle -> Integer.valueOf(vehicle.getNumberOfKilometers())>0)
                .map(v -> new VehicleDTO(v.getBrand(),v.getModel(),v.getManufacturingDate(),v.getNumberOfKilometers(),v.getDoors(),v.getPrice(),v.getCurrency(),v.getCountOfOwners()))
                .collect(Collectors.toList());
    }

    public List<VehicleDTO> getSinceToDate (String since, String to){
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-mm-dd");
        return vehicleRepository.getAll().stream()
                .filter(vehicle -> {
                    try {
                        return sdf.parse(vehicle.getManufacturingDate()).after(sdf.parse(since)) && sdf.parse(vehicle.getManufacturingDate()).before(sdf.parse(to));
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }
                })
                .map(v -> new VehicleDTO(v.getBrand(),v.getModel(),v.getManufacturingDate(),v.getNumberOfKilometers(),v.getDoors(),v.getPrice(),v.getCurrency(),v.getCountOfOwners()))
                .collect(Collectors.toList());
    }

    public List<VehicleDTO> getSinceToPrice (String since, String to){
        return vehicleRepository.getAll().stream()
                .filter(vehicle -> Double.parseDouble(vehicle.getPrice())>Double.parseDouble(since) && Double.parseDouble(vehicle.getPrice())<Double.parseDouble(to))
                .map(v -> new VehicleDTO(v.getBrand(),v.getModel(),v.getManufacturingDate(),v.getNumberOfKilometers(),v.getDoors(),v.getPrice(),v.getCurrency(),v.getCountOfOwners()))
                .collect(Collectors.toList());
    }

    public VehicleDTO getVehicleByID(Long id) {
        try {
            Vehicle vehicle = vehicleRepository.getByID(id);
            return new VehicleDTO(vehicle.getBrand(), vehicle.getModel(), vehicle.getManufacturingDate(), vehicle.getNumberOfKilometers(), vehicle.getDoors(), vehicle.getPrice(), vehicle.getCurrency(), vehicle.getCountOfOwners());

        }catch (NullPointerException nullPointerException){
            throw new RuntimeException("No se encontro el vehiculo :(");
        }
    }

}
