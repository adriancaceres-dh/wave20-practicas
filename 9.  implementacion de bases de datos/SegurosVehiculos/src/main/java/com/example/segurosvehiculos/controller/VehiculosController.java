package com.example.segurosvehiculos.controller;

import com.example.segurosvehiculos.dtos.response.CrearEntidadResponseDTO;
import com.example.segurosvehiculos.dtos.request.VehiculoRequestDTO;
import com.example.segurosvehiculos.dtos.response.MarcaModeloResponseDTO;
import com.example.segurosvehiculos.dtos.response.PatenteMarcaModeloResponseDTO;
import com.example.segurosvehiculos.dtos.response.VehiculoResponseDTO;
import com.example.segurosvehiculos.service.IVehiculosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Year;
import java.util.List;

@RestController
@RequestMapping("/vehiculos")
public class VehiculosController {
  private final IVehiculosService vehiculosService;

  public VehiculosController(IVehiculosService vehiculosService) {
    this.vehiculosService = vehiculosService;
  }

  @PostMapping("/new")
  public ResponseEntity<CrearEntidadResponseDTO> newVehicle(@RequestBody VehiculoRequestDTO dto) {
    return new ResponseEntity<>(vehiculosService.addNewVehicle(dto), HttpStatus.CREATED);
  }

  @GetMapping("/{id}")
  public ResponseEntity<VehiculoResponseDTO> getVehicle(@PathVariable Integer id) {
    return new ResponseEntity<>(vehiculosService.getVehicle(id), HttpStatus.OK);
  }

  @GetMapping
  public ResponseEntity<List<MarcaModeloResponseDTO>> getAllVehiclesOrderByYear() {
    return new ResponseEntity<>(vehiculosService.getAllVehiclesOrderByYear(), HttpStatus.OK);
  }

  @GetMapping("/cantidad-ruedas/{cantidad_ruedas}/anio/{anio}")
  public ResponseEntity<List<String>> findAllByCantRuedasGreaterThanEqualAndAnioEquals(
          @PathVariable (value = "cantidad_ruedas") Integer cantRuedas, @PathVariable Year anio) {
    return new ResponseEntity<>(vehiculosService.findAllByCantRuedasGreaterThanEqualAndAnioEquals(cantRuedas, anio), HttpStatus.OK);
  }

  @GetMapping("/expensive-accidents/{perdida}")
  public ResponseEntity<List<PatenteMarcaModeloResponseDTO>> findAllBySiniestrosPerdidaTotalGreaterThanEqual(@PathVariable Integer perdida) {
    return new ResponseEntity<>(vehiculosService.findAllBySiniestrosPerdidaTotalGreaterThanEqual(perdida), HttpStatus.OK);
  }

}
