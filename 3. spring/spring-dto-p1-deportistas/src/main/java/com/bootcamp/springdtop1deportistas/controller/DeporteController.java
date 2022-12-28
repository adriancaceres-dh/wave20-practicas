package com.bootcamp.springdtop1deportistas.controller;

import com.bootcamp.springdtop1deportistas.dto.DeporteDTO;
import com.bootcamp.springdtop1deportistas.model.Deporte;
import com.bootcamp.springdtop1deportistas.service.DeporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class DeporteController {
    @Autowired
    private DeporteService deporteService;

    @PostMapping("/addSport")
    public void addSport(@RequestBody DeporteDTO deporteDTO) {
        deporteService.add(deporteDTO);
    }

    @PostMapping("/addSports")
    public void addSport(@RequestBody DeporteDTO[] deportesDTO) {
        Arrays.stream(deportesDTO).forEach(deporteDTO -> deporteService.add(deporteDTO));
    }

    @GetMapping("/findSports")
    public ResponseEntity<List<DeporteDTO>> findSports() {
        return new ResponseEntity<>(deporteService.findByName(""), HttpStatus.OK);
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<List<DeporteDTO>> findSportByName(@PathVariable String name) {
        return new ResponseEntity<>(deporteService.findByName(name), HttpStatus.OK);
    }
}
