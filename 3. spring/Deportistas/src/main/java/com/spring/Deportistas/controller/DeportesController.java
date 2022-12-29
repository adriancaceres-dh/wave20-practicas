package com.spring.Deportistas.controller;

import com.spring.Deportistas.dto.responseDto.DeporteResponseDTO;
import com.spring.Deportistas.service.DeporteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deporte")
public class DeportesController {

    @GetMapping("/findSports")
    public ResponseEntity<List<DeporteResponseDTO>> encontrarDeportes(){
        return DeporteService.devolverTodosLosDeportes();
    }

    @GetMapping("/findSport")
    public ResponseEntity<DeporteResponseDTO> encontrarDeporte(@RequestParam String nombre){
        return DeporteService.encontrarDeporte(nombre);
    }

}
