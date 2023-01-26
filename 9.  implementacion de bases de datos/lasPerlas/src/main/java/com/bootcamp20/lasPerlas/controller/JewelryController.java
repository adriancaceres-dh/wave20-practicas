package com.bootcamp20.lasPerlas.controller;

import com.bootcamp20.lasPerlas.dtos.JewelryDTO;
import com.bootcamp20.lasPerlas.dtos.MessageDTO;
import com.bootcamp20.lasPerlas.service.IJewelryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@Validated
public class JewelryController {

    @Autowired
    IJewelryService jewelryService;

    @PostMapping("/jewelry/new")
    public ResponseEntity<MessageDTO> createJewelry(@Valid @RequestBody JewelryDTO jewelryDTO) {
        return ResponseEntity.ok(jewelryService.saveJewelry(jewelryDTO));
    }

    @GetMapping("/jewelry")
    public ResponseEntity<List<JewelryDTO>> getAllJewelry() {
        return ResponseEntity.ok(jewelryService.getAllJewelry());
    }

    @GetMapping("/jewelry/findById/{id_modificar}")
    public ResponseEntity<JewelryDTO> findByIdJewelry(@PathVariable Integer id_modificar) {
        return ResponseEntity.ok(jewelryService.getJewelryById(id_modificar));
    }

    @PutMapping("/jewelry/update/{id_modificar}")
    public ResponseEntity<MessageDTO> updateJewelry(@Valid @PathVariable Integer id_modificar, @RequestBody JewelryDTO jewelryDTO) {
        return ResponseEntity.ok(jewelryService.updateJewelry(id_modificar, jewelryDTO));
    }

    @PostMapping("/jewelry/delete/{id}")
    public ResponseEntity<MessageDTO> deleteJewelry(@PathVariable Integer id) {
        System.out.println("id = " + id);
        return ResponseEntity.ok(jewelryService.deleteJewelry(id));
    }


}
