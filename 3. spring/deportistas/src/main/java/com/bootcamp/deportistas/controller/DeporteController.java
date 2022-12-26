package com.bootcamp.deportistas.controller;

import com.bootcamp.deportistas.dto.response.DeporteResponseDto;
import com.bootcamp.deportistas.service.DeporteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DeporteController {
    private DeporteService deporteService;
    public DeporteController(){
        deporteService = new DeporteService();
    }

    @GetMapping("/findsports")
    public ResponseEntity<List<DeporteResponseDto>> findSports() {
        return new ResponseEntity<>(deporteService.findSports(), HttpStatus.OK);
    }

    @GetMapping("/findsports/{sport}")
    public ResponseEntity<DeporteResponseDto> findSport(@PathVariable String sport) {
        return new ResponseEntity<>(deporteService.findSport(sport), HttpStatus.OK);
    }

}
