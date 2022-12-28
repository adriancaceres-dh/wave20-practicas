package com.bootcamp.springdtop1deportistas.controller;

import com.bootcamp.springdtop1deportistas.dto.DeporteDTO;
import com.bootcamp.springdtop1deportistas.dto.request.DeportistaRequestDTO;
import com.bootcamp.springdtop1deportistas.dto.response.DeportistaResponseDTO;
import com.bootcamp.springdtop1deportistas.service.DeportistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class DeportistaController {
    @Autowired
    private DeportistaService deportistaService;

    @PostMapping("/addSportsPerson")
    public void addSport(@RequestBody DeportistaRequestDTO deportistaRequestDTO) {
        deportistaService.add(deportistaRequestDTO);
    }

    @PostMapping("/addSportsPeople")
    public void addSport(@RequestBody DeportistaRequestDTO[] deportistasRequestDTO) {
        Arrays.stream(deportistasRequestDTO).forEach(deportistaRequestDTO -> deportistaService.add(deportistaRequestDTO));
    }

    @GetMapping("/findSportsPeople")
    public ResponseEntity<List<DeportistaResponseDTO>> findSportsPeople() {
        return new ResponseEntity<>(deportistaService.findByName(""), HttpStatus.OK);
    }
}
