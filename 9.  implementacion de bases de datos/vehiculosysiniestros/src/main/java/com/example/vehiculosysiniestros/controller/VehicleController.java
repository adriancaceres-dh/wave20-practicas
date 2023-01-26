package com.example.vehiculosysiniestros.controller;

import com.example.vehiculosysiniestros.dto.response.VehicleLicenseAndBrandResponseDto;
import com.example.vehiculosysiniestros.dto.response.VehicleLicensePlateResponseDto;
import com.example.vehiculosysiniestros.dto.response.VehiclePlateBrandModelResponseDto;
import com.example.vehiculosysiniestros.service.interfaces.VehicleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping()
    public ResponseEntity<List<VehicleLicensePlateResponseDto>> getAllLicensePlates() {
        return ResponseEntity.ok()
                .body(vehicleService.getAllLicensePlates());
    }

    @GetMapping("/ordered-by-date")
    public ResponseEntity<List<VehicleLicenseAndBrandResponseDto>> getAllOrderedByFabricationDate() {
        return ResponseEntity.ok()
                .body(vehicleService.getAllLicenseAndBrandOrderedByFabricationYear());
    }

    @GetMapping("/more-than-4-wheels-fabricated-current")
    public ResponseEntity<List<VehicleLicensePlateResponseDto>> getAllWithMoreThan4WheelsAndFabricatedThisYear() {
        return ResponseEntity.ok()
                .body(vehicleService.getAllLicensePlatesOfVehiclesWithMoreThan4WheelsAndFabricatedThisYear());
    }

    @GetMapping("/expensive-accidents")
    public ResponseEntity<List<VehiclePlateBrandModelResponseDto>> getAllWithExpensiveAccidents() {
        return ResponseEntity.ok()
                .body(vehicleService.getVehiclesThatSufferedExpensiveAccidents());
    }
}
