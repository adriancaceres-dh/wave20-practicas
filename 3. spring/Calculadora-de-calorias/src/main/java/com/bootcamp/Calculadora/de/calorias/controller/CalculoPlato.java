package com.bootcamp.Calculadora.de.calorias.controller;

import com.bootcamp.Calculadora.de.calorias.dto.PlatoDTO;
import com.bootcamp.Calculadora.de.calorias.service.PlatosServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class CalculoPlato {
    @Autowired
    PlatosServiceImpl platosService;
    List<PlatoDTO> listaPlatosDTO = new ArrayList<>();
    @GetMapping("/plato/{nombre}/{peso}")
    public ResponseEntity<PlatoDTO> calculoDelPlato(@PathVariable String nombre, @PathVariable String peso){

        return new ResponseEntity<PlatoDTO>(platosService.platos(nombre, peso), HttpStatus.OK);
    }

    @GetMapping("/platos")
    public ResponseEntity<List<PlatoDTO>> calculoDePlatos(@RequestParam List<String> nombres, @RequestParam List<String> pesos){
        for(int i =0; i<nombres.size(); i++){
            listaPlatosDTO.add(platosService.platos(nombres.get(i),pesos.get(i)));
        }

        return new ResponseEntity<List<PlatoDTO>>(listaPlatosDTO, HttpStatus.OK);
    }
}
