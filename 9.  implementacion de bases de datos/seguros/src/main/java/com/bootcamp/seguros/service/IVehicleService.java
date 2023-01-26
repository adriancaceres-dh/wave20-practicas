package com.bootcamp.seguros.service;

import com.bootcamp.seguros.dto.SinisterDTO;
import com.bootcamp.seguros.dto.VehicleDTO;
import com.bootcamp.seguros.model.Vehicle;
import com.bootcamp.seguros.model.templates.PatenteYMarca;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IVehicleService {
    VehicleDTO createVehicle(VehicleDTO vehicleDTO);
    List<String> getAllPatentes();
    List<PatenteYMarca> getAllPatenteYMarca();
    List<String> getAllPatentesByCantidadDeRuedas();
}
