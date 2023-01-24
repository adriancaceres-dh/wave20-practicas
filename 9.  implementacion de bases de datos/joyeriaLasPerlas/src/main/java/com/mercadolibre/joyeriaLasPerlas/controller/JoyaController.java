package com.mercadolibre.joyeriaLasPerlas.controller;

import com.mercadolibre.joyeriaLasPerlas.DTO.JoyaRequestDTO;
import com.mercadolibre.joyeriaLasPerlas.DTO.JoyaResponseDTO;
import com.mercadolibre.joyeriaLasPerlas.DTO.MessageDTO;
import com.mercadolibre.joyeriaLasPerlas.service.IJoyaService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JoyaController {
    @Autowired
    private IJoyaService joyaService;
    @PostMapping("/crear")
    public ResponseEntity<MessageDTO> crearJoyaController(@RequestBody JoyaRequestDTO joyaRequestDTO){
        return new ResponseEntity<>(joyaService.crearJoya(joyaRequestDTO), HttpStatus.CREATED);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<JoyaResponseDTO>> obtenerTodasLasJoyasController() throws Exception {
        return new ResponseEntity<>(joyaService.obtenerTodasLasJoyas(), HttpStatus.OK);
    }

    @GetMapping("/Get/{id}")
    public ResponseEntity<JoyaResponseDTO> obtenerJoyaController(@PathVariable int id) throws Exception {
        return new ResponseEntity<>(joyaService.obtenerJoya(id), HttpStatus.OK);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<MessageDTO> eliminarJoya(@PathVariable int id){
        return new ResponseEntity<>(joyaService.eliminarJoya(id), HttpStatus.OK);
    }

}
