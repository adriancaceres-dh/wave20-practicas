package com.bootcamp.concesionaria_autos.controller;

import com.bootcamp.concesionaria_autos.dto.request.PostVehicleDTO;
import com.bootcamp.concesionaria_autos.dto.response.AfterGetVehicleDTO;
import com.bootcamp.concesionaria_autos.dto.response.AfterGetVehiclesDTO;
import com.bootcamp.concesionaria_autos.dto.response.AfterPostVehicleDTO;
import com.bootcamp.concesionaria_autos.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/v1/api/vehicles")
public class VehicleController {

    @Autowired
    IVehicleService vehicleService;

    @PostMapping
    public ResponseEntity<AfterPostVehicleDTO> postVehicle(@RequestBody PostVehicleDTO postVehicleDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(vehicleService.createVehicle(postVehicleDTO));
    }

    @GetMapping
    public ResponseEntity<AfterGetVehiclesDTO> getVehicles() {
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.getVehicles());
    }

    @GetMapping("/dates")
    public ResponseEntity<AfterGetVehiclesDTO> getVehiclesByDate(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate since,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate to) {
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.getVehiclesByManufacturingDate(since, to));
    }

    @GetMapping("/prices")
    public ResponseEntity<AfterGetVehiclesDTO> getVehiclesByPrice(@RequestParam double since, @RequestParam double to) {
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.getVehiclesByPrice(since, to));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AfterGetVehicleDTO> getVehicleById(@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.getVehicleById(id));
    }
}
