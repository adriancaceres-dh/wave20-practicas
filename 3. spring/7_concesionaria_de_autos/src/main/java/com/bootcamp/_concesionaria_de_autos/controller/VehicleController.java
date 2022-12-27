package com.bootcamp._concesionaria_de_autos.controller;

import com.bootcamp._concesionaria_de_autos.dto.response.VehicleDTO;
import com.bootcamp._concesionaria_de_autos.model.Vehicle;
import com.bootcamp._concesionaria_de_autos.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/vehicles")
public class VehicleController {
    @Autowired
    VehicleService vehicleService;
    @PostMapping("/")
    public ResponseEntity<String> addVehicle (@RequestBody Vehicle vehicle){
        vehicleService.addVehicle(vehicle);
        return new ResponseEntity<>("Agregado correctamente!", HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<VehicleDTO>> getUsed(){
        return new ResponseEntity<>(vehicleService.getUsed(),HttpStatus.OK);
    }

    @GetMapping("/dates")
    public ResponseEntity<List<VehicleDTO>> getSinceToDate(@RequestParam String since,
                                                           @RequestParam String to){
        return new ResponseEntity<>(vehicleService.getSinceToDate(since,to),HttpStatus.OK);
    }

    @GetMapping("/prices")
    public ResponseEntity<List<VehicleDTO>> getSinceToPrice(@RequestParam String since,
                                                            @RequestParam String to){
        return new ResponseEntity<>(vehicleService.getSinceToPrice(since,to),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleDTO> getVehicleByID(@PathVariable Long id){
        return new ResponseEntity<>(vehicleService.getVehicleByID(id),HttpStatus.OK);
    }

}
