package com.bootcamp.clothes.controller;

import com.bootcamp.clothes.dto.request.ClotheDTO;
import com.bootcamp.clothes.dto.response.MessageDTO;
import com.bootcamp.clothes.service.ClotheService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/clothes")
public class ClotheController {

    private final ClotheService clotheService;

    public ClotheController(ClotheService clotheService) {
        this.clotheService = clotheService;
    }

    @PostMapping(value = "/")
    ResponseEntity<MessageDTO> saveClothe(@RequestBody ClotheDTO clotheDTO) {
        return new ResponseEntity<>(clotheService.saveEntity(clotheDTO), HttpStatus.CREATED);
    }

    @GetMapping("/")
    ResponseEntity<List<ClotheDTO>> getAllClothes() {
        return new ResponseEntity<>(clotheService.getAllEntities(), HttpStatus.OK);
    }

    @GetMapping("/{code}")
    ResponseEntity<ClotheDTO> getByCodeClothe(@PathVariable Integer code) {
        return new ResponseEntity<>(clotheService.getEntityById(code), HttpStatus.OK);
    }

    @PutMapping("/{code}")
    ResponseEntity<MessageDTO> updateClothe(@PathVariable Integer code, @RequestBody ClotheDTO clotheDTO) {
        return new ResponseEntity<>(clotheService.updateEntity(code, clotheDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{code}")
    ResponseEntity<MessageDTO> deleteClothe(@PathVariable Integer code) {
        return new ResponseEntity<>(clotheService.deleteEntity(code), HttpStatus.OK);
    }

    @GetMapping("/size/{size}")
    ResponseEntity<List<ClotheDTO>> getSizeClothe(@PathVariable Integer size) {
        return new ResponseEntity<>(clotheService.sizeClothe(size), HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    ResponseEntity<List<ClotheDTO>> getNameClothe(@PathVariable String name) {
        return new ResponseEntity<>(clotheService.nameContainsClothe(name), HttpStatus.OK);
    }
}
