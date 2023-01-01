package com.bootcamp.Concesionario.controller;


import com.bootcamp.Concesionario.dto.VehiclesRequestDTO;
import com.bootcamp.Concesionario.dto.VehiclesResponseDTO;
import com.bootcamp.Concesionario.services.VehiclesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api")
public class VehicleController {

    @Autowired
    VehiclesService vehiclesService;

    @GetMapping("/vehicles")
    public ResponseEntity<List<VehiclesResponseDTO>> getVehiculosUsados(){
        return new ResponseEntity<>(vehiclesService.getVehiculos(), HttpStatus.OK);
    }

    @PostMapping("/vehicles")
    public ResponseEntity<VehiclesResponseDTO> postVehiculo(@RequestBody VehiclesRequestDTO vehiculo){

        return new ResponseEntity<>(vehiclesService.addVehiculo(vehiculo), HttpStatus.CREATED);
    }

    @GetMapping("/prices")
    public ResponseEntity<List<VehiclesResponseDTO>> GetVehiculosByFecha(@RequestParam int since, @RequestParam int to){
        return new ResponseEntity<>(vehiclesService.getVehiculosByPrecio(since,to), HttpStatus.OK);
    }



}

