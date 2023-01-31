package com.bootcamp.vehicles.controller;

import com.bootcamp.vehicles.dto.*;
import com.bootcamp.vehicles.service.vehicle.IVehicleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    private final IVehicleService vehicleService;

    public VehicleController(IVehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping
    ResponseEntity<MessageDTO> createVehicle(@RequestBody VehicleDTO vehicleDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(vehicleService.createVehicle(vehicleDTO));
    }

    @GetMapping
    ResponseEntity<List<VehicleDTO>> getVehicles() {
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.getAllVehicles());
    }

    @GetMapping("/patents")
    ResponseEntity<List<PatentDTO>> getPatents() {
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.getAllPatents());
    }

    @GetMapping("/patent-brands")
    ResponseEntity<List<PatentBrandYearDTO>> getPatentBrandsSortedByYear() {
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.getAllPatentBrandSortedByYear());
    }

    @GetMapping("/patent/wheels/4/year/current")
    ResponseEntity<List<PatentWheelCountYearDTO>> getPatentBrandsBy4WheelsAndCurrentYear() {
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.getAllPatentsByWheelCountAndYear(4, LocalDate.now().getYear()));
    }

    @GetMapping("/patent-brand-models/economic-loss/10000")
    ResponseEntity<List<PatentBrandModelEconomicLossDTO>> getAllPatentBrandModelByTenThousandEconomicLoss() {
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.getAllPatentBrandModelByEconomicLoss(10000.0));
    }

    @GetMapping("/economic-loss/10000")
    ResponseEntity<List<VehicleAccidentDTO>> getAllByTenThousandEconomicLoss() {
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.getAllByEconomicLoss(10000.0));
    }
}
