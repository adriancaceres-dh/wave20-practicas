package com.deportistas.deportistas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deportistas.deportistas.dto.response.BuscaDeporteResponseDto;
import com.deportistas.deportistas.dto.response.ListaDeportesResponseDto;
import com.deportistas.deportistas.services.DeporteService;

@RestController
@RequestMapping("/sports")
public class DeporteController {

    @Autowired
    private DeporteService deporteService;

    @GetMapping("/findSports")
    public List<ListaDeportesResponseDto> listaTodosLosDeportes() {
        return deporteService.listarDeportes();
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<BuscaDeporteResponseDto> buscarDeporte(@PathVariable String name) {
        BuscaDeporteResponseDto deporteResultado = deporteService.buscarDeporte(name);
        if (deporteResultado == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
        return new ResponseEntity<>(deporteResultado, HttpStatus.FOUND);
    }
}
