package com.mercadolibre.SegurosAutos.controllers;

import com.mercadolibre.SegurosAutos.models.Vehiculo;
import com.mercadolibre.SegurosAutos.services.ICRUDServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class VehiculoController {
    @Autowired
    ICRUDServices crudServices;

    @GetMapping("/GetMarcaYPatente")
    public ResponseEntity<List<Map<String,String>>> getMarcaYPatenteController(){
        return ResponseEntity.ok(crudServices.getMarcaYPatenteService());
    }

    @GetMapping("/GetMarcaYPatenteV2")
    public ResponseEntity<List<Vehiculo>> getMarcaYPatenteControllerV2(){
        return ResponseEntity.ok(crudServices.getMarcaYPatenteServiceV2());
    }

    @GetMapping("/GetMarcaYPatenteAnio")
    public ResponseEntity<List<Map<String,String>>> getMarcayPatenteByAnioFabricacionController(){
        return ResponseEntity.ok(crudServices.getMarcayPatenteByAnioFabricacionService());
    }

    @GetMapping("/GetVehiculoPorRuedasYAnio")
    public ResponseEntity<List<Vehiculo>> getVehiculoByRuedasYAnioController(){
        return ResponseEntity.ok(crudServices.getVehiculoByRuedasYAnioService());
    }

    @GetMapping("/GetVehiculoBySiniestro")
    ResponseEntity<List<Vehiculo>> getBySiniestroServiceController(){
        return ResponseEntity.ok(crudServices.getBySiniestroService());
    }

    @GetMapping("/get4Sql")
    ResponseEntity<List<Map<String,?>>> get4Sql(){
        return ResponseEntity.ok(crudServices.get4SQLService());
    }

}
