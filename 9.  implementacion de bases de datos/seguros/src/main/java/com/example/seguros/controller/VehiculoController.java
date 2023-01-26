package com.example.seguros.controller;

import com.example.seguros.dto.VehiculoDto;
import com.example.seguros.dto.VehiculoSimpleDto;
import com.example.seguros.dto.templates.TemplateMarcaYPatente;
import com.example.seguros.service.interfaces.IVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/vehiculo")
public class VehiculoController {
    @Autowired
    private IVehiculoService vehiculoService;

    @PostMapping("/")
    public ResponseEntity<VehiculoSimpleDto> create(@RequestBody VehiculoSimpleDto vehiculoSimpleDto){
        return new ResponseEntity<>(vehiculoService.newEntity(vehiculoSimpleDto), HttpStatus.OK);
    }

    @GetMapping("/getAllByPatente")
    public ResponseEntity<List<?>> getAllByPatente(){
        return new ResponseEntity<>(vehiculoService.getAllEntities(), HttpStatus.OK);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<TemplateMarcaYPatente>> getAllByPatenteAndMarca(){
        return new ResponseEntity<>(vehiculoService.getAllPatenteAndMarca(), HttpStatus.OK);
    }
    @GetMapping("/getByCantRuedas")
    public ResponseEntity<List<VehiculoDto>> getAllByCantRuedas(){
        return new ResponseEntity<>(vehiculoService.getAllByCantRuedas(),HttpStatus.OK);
    }

}
