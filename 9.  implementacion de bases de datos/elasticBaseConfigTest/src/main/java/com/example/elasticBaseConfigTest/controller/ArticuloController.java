package com.example.elasticBaseConfigTest.controller;

import com.example.elasticBaseConfigTest.domain.Articulo;
import com.example.elasticBaseConfigTest.service.ArticuloService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArticuloController {

    private final ArticuloService articuloService;

    public ArticuloController(ArticuloService articuloService) {
        this.articuloService = articuloService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Articulo>> getAllArticulos() {
        return ResponseEntity.ok(articuloService.getAllArticulos());
    }

    @GetMapping("/titulo/{search}")
    public ResponseEntity<Articulo> getByTitle(@PathVariable String search) {
        return ResponseEntity.ok(articuloService.getArticuloByTitle(search));
    }
}
