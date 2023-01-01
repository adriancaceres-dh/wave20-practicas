package com.bootcamp.Concesionario.services;

import com.bootcamp.Concesionario.dto.VehiclesRequestDTO;
import com.bootcamp.Concesionario.dto.VehiclesResponseDTO;
import com.bootcamp.Concesionario.models.Vehicles;
import com.bootcamp.Concesionario.repository.VehiclesRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehiclesService {

    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    VehiclesRepository vehiclesRepository;

    public List<VehiclesResponseDTO> getVehiculos() {
        return vehiclesRepository.getAllVehiculos().stream().map(vehicles -> modelMapper.map(vehicles,VehiclesResponseDTO.class)).collect(Collectors.toList());
    }

    public VehiclesResponseDTO addVehiculo(VehiclesRequestDTO vehiculo) {

        VehiclesRequestDTO vehiculoAInsertar = vehiculo;
        vehiclesRepository.addVehiculo(modelMapper.map(vehiculoAInsertar, Vehicles.class));
        return modelMapper.map(vehiculoAInsertar,VehiclesResponseDTO.class);


    }

    public List<VehiclesResponseDTO> getVehiculosByPrecio(int since, int to) {
        return vehiclesRepository.getAllVehiculos().stream().filter(vehicles -> vehicles.getPrice()>=since && vehicles.getPrice()<=to)
                .map(vehicles -> modelMapper.map(vehicles, VehiclesResponseDTO.class)).collect(Collectors.toList());
    }

}

