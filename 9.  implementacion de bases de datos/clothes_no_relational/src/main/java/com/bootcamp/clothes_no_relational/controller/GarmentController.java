package com.bootcamp.clothes_no_relational.controller;

import com.bootcamp.clothes_no_relational.dto.common.GarmentDTO;
import com.bootcamp.clothes_no_relational.dto.response.MessageDTO;
import com.bootcamp.clothes_no_relational.service.IGarmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clothes")
public class GarmentController {

    IGarmentService garmentService;

    public GarmentController(IGarmentService garmentService) {
        this.garmentService = garmentService;
    }

    @PostMapping
    ResponseEntity<MessageDTO> createGarment(@RequestBody GarmentDTO garmentDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(garmentService.create(garmentDTO));
    }

    @GetMapping
    ResponseEntity<List<GarmentDTO>> getClothes(@RequestParam(required = false) String name) {
        if (name != null)
            return ResponseEntity.status(HttpStatus.OK).body(garmentService.getByNameContaining(name));

        return ResponseEntity.status(HttpStatus.OK).body(garmentService.getAll());
    }

    @GetMapping("/{term}")
    ResponseEntity<?> getGarmentByCode(@PathVariable String term) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(garmentService.getById(Long.parseLong(term)));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.OK).body(garmentService.getBySizeEquals(term));
        }
    }

    @PutMapping("/{code}")
    ResponseEntity<MessageDTO> updateGarmentByCode(@PathVariable Long code, @RequestBody GarmentDTO garmentDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(garmentService.update(code, garmentDTO));
    }

    @DeleteMapping("/{code}")
    ResponseEntity<MessageDTO> deleteGarmentByCode(@PathVariable Long code) {
        return ResponseEntity.status(HttpStatus.OK).body(garmentService.deleteById(code));
    }
}
