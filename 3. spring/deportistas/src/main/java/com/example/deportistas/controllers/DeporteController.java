package com.example.deportistas.controllers;

import com.example.deportistas.models.Deporte;
import com.example.deportistas.services.DeporteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
public class DeporteController {

    private final DeporteService deporteService;

    public DeporteController() {
        deporteService = new DeporteService();
    }

    @PostMapping("/sports")
    public ResponseEntity<String> addDeporte(@RequestBody Deporte deporte) {
        deporteService.addDeporte(deporte);
        return new ResponseEntity<>("Deporte agregado", HttpStatus.CREATED);
    }

    @GetMapping("/findSports")
    public List<Deporte> getDeportes() {
        return deporteService.getAllDeportes();
    }

    @GetMapping("/findSports/{name}")
    public ResponseEntity<Deporte> getDeporteByName(@PathVariable String name) {
        Deporte deporteEncontrado = deporteService.getDeporte(name);
        if (Objects.isNull(deporteEncontrado)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(deporteEncontrado);
    }
}
