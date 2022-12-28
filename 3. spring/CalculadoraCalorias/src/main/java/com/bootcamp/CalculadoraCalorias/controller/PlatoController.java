package com.bootcamp.CalculadoraCalorias.controller;

import com.bootcamp.CalculadoraCalorias.dto.IngredienteDTO;
import com.bootcamp.CalculadoraCalorias.dto.PlatoDTO;
import com.bootcamp.CalculadoraCalorias.service.PlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/plato")
public class PlatoController {
    @Autowired
    private PlatoService platoService;

    @GetMapping()
    public ResponseEntity<Double> calcularCaloriasPorPlato(@RequestBody PlatoDTO platoDTO){
        return new ResponseEntity<>(platoService.calcularCaloriasPorPlato(platoDTO), HttpStatus.OK);
    }

    @GetMapping("/ingredientes")
    public ResponseEntity<Set<String>> informacionPlato(@RequestBody PlatoDTO platoDTO){
        return new ResponseEntity<>(platoService.informacionPlato(platoDTO), HttpStatus.OK);
    }

    @GetMapping("/caloria")
    public ResponseEntity<List<IngredienteDTO>> masCalorico (@RequestBody PlatoDTO platoDTO){
        return new ResponseEntity<>(platoService.masCalorico(platoDTO), HttpStatus.OK);
    }

    @GetMapping("/completo")
    public ResponseEntity<List<String>> completo (@RequestBody List<PlatoDTO> listaPlatos){
        return new ResponseEntity<>(platoService.completo(listaPlatos), HttpStatus.OK);
    }

}
