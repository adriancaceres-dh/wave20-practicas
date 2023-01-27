package com.example.segurosvehiculos.controller;

import com.example.segurosvehiculos.dtos.response.CrearEntidadResponseDTO;
import com.example.segurosvehiculos.dtos.request.SiniestroRequestDTO;
import com.example.segurosvehiculos.dtos.response.PerdidaTotalDTO;
import com.example.segurosvehiculos.dtos.response.SiniestroResponseDTO;
import com.example.segurosvehiculos.service.ISiniestrosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/siniestros")
public class SiniestrosController {

  private final ISiniestrosService siniestrosService;

  public SiniestrosController(ISiniestrosService siniestrosService) {
    this.siniestrosService = siniestrosService;
  }

  @PostMapping("/new")
  public ResponseEntity<CrearEntidadResponseDTO> addNewSiniestro(@RequestBody SiniestroRequestDTO dto) {
    return new ResponseEntity<>(siniestrosService.addNewSiniestro(dto), HttpStatus.CREATED);
  }

  @GetMapping("/{id}")
  public ResponseEntity<SiniestroResponseDTO> getSiniestro(@PathVariable Integer id) {
    return new ResponseEntity<>(siniestrosService.getSiniestro(id), HttpStatus.OK);
  }

  @GetMapping("/perdidaTotal/{perdida}")
  public ResponseEntity<PerdidaTotalDTO> getPerdidasTotales(@RequestParam Integer perdida) {
    return new ResponseEntity<>(siniestrosService.getPerdidaTotal(perdida), HttpStatus.OK);
  }
}
