package com.example.seguros.controller;

import com.example.seguros.dto.SiniestroDto;
import com.example.seguros.dto.VehiculoDto;
import com.example.seguros.dto.templates.TemplateMatriculaMarcaYModelo;
import com.example.seguros.service.interfaces.ISiniestroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("siniestro")
public class SiniestroController {
    @Autowired
    private ISiniestroService siniestroService;

    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody SiniestroDto siniestroDto) {
        return new ResponseEntity<>(siniestroService.newEntity(siniestroDto), HttpStatus.OK);
    }
    @GetMapping("/getBySiniestro")
    public ResponseEntity<List<TemplateMatriculaMarcaYModelo>> getAllByCantRuedas(){
        return new ResponseEntity<>(siniestroService.getAllMarcaModeloPatente(),HttpStatus.OK);
    }
    @GetMapping("/getByModeloMarcaPatente")
    public ResponseEntity<List<TemplateMatriculaMarcaYModelo>> getAllByMarcaModeloYPatente(){
        return new ResponseEntity<>(siniestroService.getAllMarcaModeloPatente(),HttpStatus.OK);
    }
}
