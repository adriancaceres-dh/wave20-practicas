package com.example.demo.controller;

import com.example.demo.dto.MessageDto;
import com.example.demo.dto.PersonDto;
import com.example.demo.dto.SinisterDto;
import com.example.demo.dto.VehicleDto;
import com.example.demo.service.SinisterService;
import com.example.demo.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @PostMapping("/add")
    public ResponseEntity<VehicleDto> add(@RequestBody VehicleDto dto) {
        return ResponseEntity.ok(vehicleService.saveEntity(dto));
    }

    @GetMapping
    public ResponseEntity<List<VehicleDto>> getAll() {
        return ResponseEntity.ok(vehicleService.getAllEntities());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<MessageDto> delete(@PathVariable Integer id) {
        return ResponseEntity.ok(vehicleService.deleteEntity(id));
    }

    @GetMapping("/byMarca")
    public ResponseEntity<List<VehicleDto>> getByMarca(@RequestParam(name = "marca") String marca) {
        return ResponseEntity.ok(vehicleService.getEntityByMarca(marca));
    }
}
