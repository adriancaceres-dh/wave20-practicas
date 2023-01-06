package com.bootcamp.concesionaria_autos.service;

import com.bootcamp.concesionaria_autos.dto.common.VehicleDTO;
import com.bootcamp.concesionaria_autos.dto.request.PostVehicleDTO;
import com.bootcamp.concesionaria_autos.dto.response.AfterGetVehicleDTO;
import com.bootcamp.concesionaria_autos.dto.response.AfterGetVehiclesDTO;
import com.bootcamp.concesionaria_autos.dto.response.AfterPostVehicleDTO;
import com.bootcamp.concesionaria_autos.exception.VehicleCreationException;
import com.bootcamp.concesionaria_autos.exception.VehicleNotFoundException;
import com.bootcamp.concesionaria_autos.model.Vehicle;
import com.bootcamp.concesionaria_autos.repository.IVehicleRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements IVehicleService {

    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    IVehicleRepository vehicleRepository;

    public VehicleServiceImpl() {
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
    }

    @Override
    public AfterPostVehicleDTO createVehicle(PostVehicleDTO postVehicleDTO) {
        try {
            Vehicle vehicle = modelMapper.map(postVehicleDTO, Vehicle.class);
            int id = vehicleRepository.createVehicle(vehicle);
            return new AfterPostVehicleDTO(id, "The vehicle was added to the repository");
        } catch (Exception e) {
            throw new VehicleCreationException("There was an error, the vehicle was not added to the repository");
        }
    }

    @Override
    public AfterGetVehiclesDTO getVehicles() {
        Set<Vehicle> vehicles = vehicleRepository.getVehicles();
        return new AfterGetVehiclesDTO(vehicles.size(), vehicles.stream().map(vehicle -> modelMapper.map(vehicle, VehicleDTO.class)).collect(Collectors.toList()));
    }

    @Override
    public AfterGetVehiclesDTO getVehiclesByManufacturingDate(LocalDate since, LocalDate to) {
        Set<Vehicle> vehicles = vehicleRepository.getVehiclesByManufacturingDate(since, to);
        return new AfterGetVehiclesDTO(vehicles.size(), vehicles.stream().map(vehicle -> modelMapper.map(vehicle, VehicleDTO.class)).collect(Collectors.toList()));
    }

    @Override
    public AfterGetVehiclesDTO getVehiclesByPrice(double since, double to) {
        Set<Vehicle> vehicles = vehicleRepository.getVehiclesByPrice(since, to);
        return new AfterGetVehiclesDTO(vehicles.size(), vehicles.stream().map(vehicle -> modelMapper.map(vehicle, VehicleDTO.class)).collect(Collectors.toList()));
    }

    @Override
    public AfterGetVehicleDTO getVehicleById(int id) {
        Optional<Vehicle> vehicle = vehicleRepository.getVehicleById(id);

        if (vehicle.isEmpty())
            throw new VehicleNotFoundException("The requested vehicle does not exist in the repository");

        return modelMapper.map(vehicle.get(), AfterGetVehicleDTO.class);
    }
}
