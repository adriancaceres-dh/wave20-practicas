package com.bootcamp.showroom.controller;

import com.bootcamp.showroom.dto.ClothingDto;
import com.bootcamp.showroom.dto.MessageDto;
import com.bootcamp.showroom.service.interfaces.IClothingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clothes")
public class ClothingController {

    private final IClothingService clothingService;

    public ClothingController(IClothingService clothingService) {
        this.clothingService = clothingService;
    }

    // CREATE AN ENTRY
    @PostMapping("")
    public ResponseEntity<ClothingDto> createClothing(@RequestBody ClothingDto clothingDto) {
        return ResponseEntity.ok(clothingService.createClothing(clothingDto));
    }

    // GET ALL ENTRIES
    @GetMapping("")
    public ResponseEntity<List<ClothingDto>> getAllClothing(@RequestParam (required = false) String name) {
        return ResponseEntity.ok(clothingService.getAllClothingByNameContains(name));
    }

    // GET AN ENTRY BY ID
    @GetMapping("/{id}")
    public ResponseEntity<ClothingDto> getClothingById(@PathVariable Long id) {
        return ResponseEntity.ok(clothingService.getClothingById(id));
    }

    // UPDATE AN EXISTING ENTRY BY ID
    @PutMapping("/{id}")
    public ResponseEntity<ClothingDto> updateClothingById(@RequestBody ClothingDto clothingDto, @PathVariable Long id) {
        return ResponseEntity.ok(clothingService.updateClothingById(clothingDto, id));
    }

    // DELETE AN EXISTING ENTRY
    @DeleteMapping("/{id}")
    public ResponseEntity<MessageDto> updateClothingById(@PathVariable Long id) {
        return ResponseEntity.ok(clothingService.deleteClothingById(id));
    }

    // GET ALL ENTRIES BY SIZE
    @GetMapping("/size/{size}")
    public ResponseEntity<List<ClothingDto>> getAllClothingBySize(@PathVariable String size) {
        return ResponseEntity.ok(clothingService.getAllClothingBySize(size));
    }
}
