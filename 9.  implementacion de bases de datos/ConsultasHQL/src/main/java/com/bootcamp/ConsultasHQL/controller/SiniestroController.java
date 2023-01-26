package com.bootcamp.ConsultasHQL.controller;

import com.bootcamp.ConsultasHQL.dto.request.SiniestroRequestDTO;
import com.bootcamp.ConsultasHQL.service.ISiniestroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/siniestro")
public class SiniestroController {

    private final ISiniestroService siniestroService;

    public SiniestroController(ISiniestroService siniestroService) {
        this.siniestroService = siniestroService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createSiniestro(@RequestBody SiniestroRequestDTO dto){
        return ResponseEntity.ok(siniestroService.create(dto));
    }
}
