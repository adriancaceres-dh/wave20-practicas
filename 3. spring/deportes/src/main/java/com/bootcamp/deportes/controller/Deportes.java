package com.bootcamp.deportes.controller;

import com.bootcamp.deportes.dto.PersonaDTO;
import com.bootcamp.deportes.model.Deporte;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.bootcamp.deportes.DeportesApplication.dService;
import static com.bootcamp.deportes.DeportesApplication.pService;

@RestController
public class Deportes {

    @GetMapping ("/")
    public String home () {
        return "Para ver todos los deportes: /findSports \n" +
                "Para consultar si un deporte existe: /findSports/{deporteABuscar} \n" +
                "Para ver todos los deportistas: /findSportsPersons";
    }

    @GetMapping ("/findSports")
    public String listarDeportes () {
        return dService.getDeporteList().stream().map(Deporte::getNombre).collect(Collectors.toList()).toString();
    }

    @GetMapping ("/findSports/{nombre}")
    public ResponseEntity<String> listarDeportes (@PathVariable String nombre) {
        Optional<Deporte> aBuscar = dService.getDeporteList().stream().filter(d -> d.getNombre().equals(nombre)).findFirst();
        return aBuscar.map(deporte -> new ResponseEntity<>("El deporte " + nombre + "es de nivel: " + deporte.getNivel(), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>("No hay un deporte de nombre " + nombre, HttpStatus.OK));
    }

    @GetMapping ("/findSportsPersons")
    public ResponseEntity<List<PersonaDTO>> listarDeportistas () {
        List<PersonaDTO> deportistas = pService.getPersonaList().stream().map(p -> new PersonaDTO(p.getNombre(), p.getApellido(), p.getDeporte().getNombre())).collect(Collectors.toList());
        return new ResponseEntity<>(deportistas, HttpStatus.OK);
    }
}
