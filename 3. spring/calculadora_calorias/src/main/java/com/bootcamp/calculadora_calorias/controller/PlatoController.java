package com.bootcamp.calculadora_calorias.controller;

import com.bootcamp.calculadora_calorias.dto.PlatoDTO;
import com.bootcamp.calculadora_calorias.service.IPlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlatoController {
    @Autowired
    IPlatoService platoService;

    @GetMapping("/platos/{nombre}")
    ResponseEntity<PlatoDTO> getInformacionPlato(@PathVariable String nombre) {
        return ResponseEntity.ok(platoService.obtenerInformacionPlato(nombre));
    }
}
