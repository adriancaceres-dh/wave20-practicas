package com.bootcamp.concesionaria_autos.service;

import com.bootcamp.concesionaria_autos.dto.request.PostVehicleDTO;
import com.bootcamp.concesionaria_autos.dto.response.AfterGetVehicleDTO;
import com.bootcamp.concesionaria_autos.dto.response.AfterGetVehiclesDTO;
import com.bootcamp.concesionaria_autos.dto.response.AfterPostVehicleDTO;

import java.time.LocalDate;

public interface IVehicleService {

    AfterPostVehicleDTO createVehicle(PostVehicleDTO postVehicleDTO);
    AfterGetVehiclesDTO getVehicles();
    AfterGetVehiclesDTO getVehiclesByManufacturingDate(LocalDate since, LocalDate to);
    AfterGetVehiclesDTO getVehiclesByPrice(double since, double to);
    AfterGetVehicleDTO getVehicleById(int id);
}
