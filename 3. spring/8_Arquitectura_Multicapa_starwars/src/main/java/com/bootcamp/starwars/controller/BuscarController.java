package com.bootcamp.starwars.controller;

import com.bootcamp.starwars.dto.response.PersonajeResponseDto;
import com.bootcamp.starwars.service.BuscarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BuscarController {

    @Autowired
    private BuscarService buscarService;

    @GetMapping("/{query}")
    public ResponseEntity<List<PersonajeResponseDto>> find(@PathVariable String query) {
        return ResponseEntity.ok(buscarService.find(query));
    }
}
