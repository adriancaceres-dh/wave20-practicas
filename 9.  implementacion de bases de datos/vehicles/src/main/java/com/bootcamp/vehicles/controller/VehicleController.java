package com.bootcamp.vehicles.controller;

import com.bootcamp.vehicles.dto.PatentBrandDTO;
import com.bootcamp.vehicles.dto.PatentBrandModelDTO;
import com.bootcamp.vehicles.dto.PatentDTO;
import com.bootcamp.vehicles.dto.VehicleAccidentDTO;
import com.bootcamp.vehicles.service.IVehicleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    private final IVehicleService vehicleService;

    public VehicleController(IVehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("/patents")
    ResponseEntity<List<PatentDTO>> getPatents() {
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.getAllPatents());
    }

    @GetMapping("/patent-brands")
    ResponseEntity<List<PatentBrandDTO>> getPatentBrandsSortedByYear() {
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.getAllPatentBrandSortedByYear());
    }

    @GetMapping("/patent/wheels/4/year/2022")
    ResponseEntity<List<PatentDTO>> getPatentBrandsBy4WheelsAndCurrentYear() {
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.getAllPatentsByWheelCountAndYear(4, LocalDate.now().getYear()));
    }

    @GetMapping("/patent-brand-models/economic-loss/10000")
    ResponseEntity<List<PatentBrandModelDTO>> getAllPatentBrandModelByTenThousandEconomicLoss() {
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.getAllPatentBrandModelByEconomicLoss(10000.0));
    }

    @GetMapping("/economic-loss/10000")
    ResponseEntity<List<VehicleAccidentDTO>> getAllByTenThousandEconomicLoss() {
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.getAllByEconomicLoss(10000.0));
    }
}
