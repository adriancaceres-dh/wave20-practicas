package com.wave20.ejercicio_deportistas.controller;

import com.wave20.ejercicio_deportistas.DTO.DeporteDTO;
import com.wave20.ejercicio_deportistas.DTO.PersonaDTO;
import com.wave20.ejercicio_deportistas.DTO.PersonaDeporteDTO;
import com.wave20.ejercicio_deportistas.service.DeporteService;
import com.wave20.ejercicio_deportistas.service.PersonaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/findSports")
public class Controller {

    @GetMapping
    public ResponseEntity<List<DeporteDTO>> listarDeportes() {
        //Los servicios se declararon estaticos solo con la finalidad de agilizar el ejercicio.
        return new ResponseEntity<>(DeporteService.listarDeportes(), HttpStatus.OK);
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<String> nivelDeporte(@PathVariable String nombre) {
        Optional<DeporteDTO> deporteDto = DeporteService.getDeportePorNombre(nombre);
        if (deporteDto.isPresent()) {
            return new ResponseEntity<>(deporteDto.get().getNivel(), HttpStatus.OK);

        } else {
            return new ResponseEntity<>("No se encontró el deporte", HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/personasDeportistas")
    public ResponseEntity<List<PersonaDeporteDTO>> getPersonaDeportista() {

        return new ResponseEntity<>(PersonaService.mostarPersonasDeportistas(), HttpStatus.OK);

    }
}
