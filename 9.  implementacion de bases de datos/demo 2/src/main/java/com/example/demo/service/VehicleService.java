package com.example.demo.service;

import com.example.demo.dto.MessageDto;
import com.example.demo.dto.SinisterDto;
import com.example.demo.dto.VehicleDto;
import com.example.demo.exception.NotFoundException;
import com.example.demo.model.Sinister;
import com.example.demo.model.Vehicle;
import com.example.demo.repository.IVehicleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VehicleService implements IVehicleService{

    @Autowired
    IVehicleRepository vehicleRepository;

    ModelMapper mapper = new ModelMapper();

    @Override
    public VehicleDto saveEntity(VehicleDto dto) {
        Vehicle vehicle = mapper.map(dto, Vehicle.class);
        vehicle.setEliminado(false);
        return mapper.map(vehicleRepository.save(vehicle), VehicleDto.class);
    }

    @Override
    public VehicleDto getEntityById(Integer id) throws NotFoundException {
        Optional<Vehicle> vehicle = vehicleRepository.findById(id);
        if (!vehicle.isPresent())
            throw new NotFoundException(new MessageDto(404, "No se encontró el recurso solicitado"));
        return mapper.map(vehicle.get(), VehicleDto.class);

    }

    @Override
    public List<VehicleDto> getAllEntities() {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        return vehicles.stream().map(v -> mapper.map(v, VehicleDto.class)).collect(Collectors.toList());
    }

    @Override
    public MessageDto deleteEntity(Integer id) {
        Optional<Vehicle> vehicle = vehicleRepository.findById(id);
        if (vehicle.isPresent() && vehicle.get().isEliminado())
            return new MessageDto(400, "El recurso no existe");
        vehicleRepository.logicDelete(id);
            return new MessageDto(200, "El recurso fue eliminado con exito");
    }
}
