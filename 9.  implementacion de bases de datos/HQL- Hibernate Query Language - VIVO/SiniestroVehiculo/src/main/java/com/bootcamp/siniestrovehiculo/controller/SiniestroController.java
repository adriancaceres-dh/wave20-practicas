package com.bootcamp.siniestrovehiculo.controller;

import com.bootcamp.siniestrovehiculo.dto.MessageDTO;
import com.bootcamp.siniestrovehiculo.dto.SiniestroDTO;
import com.bootcamp.siniestrovehiculo.service.interfaces.ISiniestroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/api/siniestros")
public class SiniestroController {

    @Autowired
    ISiniestroService siniestroService;

    @GetMapping("")
    public ResponseEntity<List<SiniestroDTO>> getAllSiniestros() {
        return ResponseEntity.ok(siniestroService.getAllEntities());
    }

    @PostMapping("/new")
    public ResponseEntity<SiniestroDTO> createSiniestro(@RequestBody SiniestroDTO siniestroDTO) {
        return ResponseEntity.ok(siniestroService.saveEntity(siniestroDTO));
    }

    @PutMapping("/update")
    public ResponseEntity<SiniestroDTO> updateSiniestro(@RequestBody SiniestroDTO siniestroDTO) {
        return ResponseEntity.ok(siniestroService.saveEntity(siniestroDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SiniestroDTO> getSiniestroById(@PathVariable Long id) {
        return ResponseEntity.ok(siniestroService.getEntityById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<MessageDTO> deleteSiniestroById(@PathVariable Long id) {
        return ResponseEntity.ok(siniestroService.deleteEntity(id));
    }
}
