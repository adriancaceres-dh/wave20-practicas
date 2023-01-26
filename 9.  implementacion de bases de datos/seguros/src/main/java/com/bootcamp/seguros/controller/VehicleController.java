package com.bootcamp.seguros.controller;

import com.bootcamp.seguros.dto.SinisterDTO;
import com.bootcamp.seguros.dto.VehicleDTO;
import com.bootcamp.seguros.model.Vehicle;
import com.bootcamp.seguros.model.templates.PatenteYMarca;
import com.bootcamp.seguros.service.ISinisterService;
import com.bootcamp.seguros.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VehicleController {
    @Autowired
    private IVehicleService vehicleService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody VehicleDTO vehicleDTO){
        return new ResponseEntity<>(vehicleService.createVehicle(vehicleDTO), HttpStatus.ACCEPTED);
    }
    @GetMapping("/getAllPatentes")
    public ResponseEntity<List<String>> getAllpatentes(){
        return new ResponseEntity<>(vehicleService.getAllPatentes(),HttpStatus.ACCEPTED);
    }
    @GetMapping("/getAllPatenteYMarca")
    public ResponseEntity<List<PatenteYMarca>> getAllpatentesYMarca(){
        return new ResponseEntity<>(vehicleService.getAllPatenteYMarca(),HttpStatus.ACCEPTED);
    }
    @GetMapping("/getAllPatentesByCantidadDeRuedas")
    public ResponseEntity<List<String>> getAllPatentesByCantidadDeRuedas(){
        return new ResponseEntity<>(vehicleService.getAllPatentesByCantidadDeRuedas(),HttpStatus.ACCEPTED);
    }


}
