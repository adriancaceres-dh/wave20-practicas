package com.example.demo.controller;

import com.example.demo.dto.SinisterDto;
import com.example.demo.dto.VehicleDto;
import com.example.demo.service.SinisterService;
import com.example.demo.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @PostMapping("/add")
    public ResponseEntity<VehicleDto> add(VehicleDto dto) {
        return ResponseEntity.ok(vehicleService.saveEntity(dto));
    }

    @GetMapping
    public ResponseEntity<List<VehicleDto>> getAll() {
        return ResponseEntity.ok(vehicleService.getAllEntities());
    }
}
