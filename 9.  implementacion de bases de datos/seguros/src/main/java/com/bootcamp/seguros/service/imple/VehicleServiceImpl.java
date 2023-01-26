package com.bootcamp.seguros.service.imple;

import com.bootcamp.seguros.dto.SinisterDTO;
import com.bootcamp.seguros.dto.VehicleDTO;
import com.bootcamp.seguros.model.Sinister;
import com.bootcamp.seguros.model.Vehicle;
import com.bootcamp.seguros.model.templates.PatenteYMarca;
import com.bootcamp.seguros.repository.VehicleRepository;
import com.bootcamp.seguros.service.IVehicleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements IVehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    ModelMapper mapper = new ModelMapper();
    @Override
    public VehicleDTO createVehicle(VehicleDTO vehicleDTO) {
        Vehicle vehicle = Vehicle.builder()
                .patente(vehicleDTO.getPatente())
                .marca(vehicleDTO.getMarca())
                .modelo(vehicleDTO.getModelo())
                .anoDeFabricacion(vehicleDTO.getAnoDeFabricacion())
                .cantidadDeRuedas(vehicleDTO.getCantidadDeRuedas())
                .build();
        vehicleRepository.save(vehicle);
        return mapper.map(vehicle, VehicleDTO.class);
    }

    @Override
    public List<String> getAllPatentes() {
        return vehicleRepository.getAllPatentes();
    }
    @Override
    public List<PatenteYMarca> getAllPatenteYMarca() {
        return vehicleRepository.getAllPatenteYMarca();
    }
    @Override
    public List<String> getAllPatentesByCantidadDeRuedas() {
        return vehicleRepository.getAllPatentesByCantidadDeRuedas();
    }


}
