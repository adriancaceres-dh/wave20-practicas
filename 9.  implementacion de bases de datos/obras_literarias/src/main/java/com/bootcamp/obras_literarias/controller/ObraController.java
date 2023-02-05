package com.bootcamp.obras_literarias.controller;

import com.bootcamp.obras_literarias.dto.MensajeDTO;
import com.bootcamp.obras_literarias.dto.ObraDTO;
import com.bootcamp.obras_literarias.service.IObraService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/obras_literarias")
public class ObraController {

    IObraService obraService;

    public ObraController(IObraService obraService) {
        this.obraService = obraService;
    }

    @PostMapping
    public ResponseEntity<MensajeDTO> createObra(@RequestBody ObraDTO obraDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(obraService.createObra(obraDTO));
    }

    @GetMapping
    public ResponseEntity<List<ObraDTO>> getObras() {
        return ResponseEntity.status(HttpStatus.OK).body(obraService.getObras());
    }

    @GetMapping("/autor/{autor}")
    public ResponseEntity<List<ObraDTO>> getObrasByAutor(@PathVariable String autor) {
        return ResponseEntity.status(HttpStatus.OK).body(obraService.getObrasByAutor(autor));
    }

    @GetMapping("/titulo/{palabra}")
    public ResponseEntity<List<ObraDTO>> getObrasByPalabra(@PathVariable String palabra) {
        return ResponseEntity.status(HttpStatus.OK).body(obraService.getObrasByPalabra(palabra));
    }

    @GetMapping("/publicacion/after/{publicacion}")
    public ResponseEntity<List<ObraDTO>> getObrasAfterPublicacion(@PathVariable Integer publicacion) {
        return ResponseEntity.status(HttpStatus.OK).body(obraService.getObrasAfterPublicacion(publicacion));
    }

    @GetMapping("/publicacion/before/{publicacion}")
    public ResponseEntity<List<ObraDTO>> getObrasBeforePublicacion(@PathVariable Integer publicacion) {
        return ResponseEntity.status(HttpStatus.OK).body(obraService.getObrasBeforePublicacion(publicacion));
    }

    @GetMapping("/editorial/{editorial}")
    public ResponseEntity<List<ObraDTO>> getObrasByEditorial(@PathVariable String editorial) {
        return ResponseEntity.status(HttpStatus.OK).body(obraService.getObrasByEditorial(editorial));
    }
}
