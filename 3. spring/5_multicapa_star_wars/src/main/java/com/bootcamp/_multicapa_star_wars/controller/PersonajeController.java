package com.bootcamp._multicapa_star_wars.controller;

import com.bootcamp._multicapa_star_wars.dto.PersonajeDTO;
import com.bootcamp._multicapa_star_wars.model.PersonajeEntity;
import com.bootcamp._multicapa_star_wars.repository.PersonajeRepository;
import com.bootcamp._multicapa_star_wars.service.PersonajeDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonajeController {

    @Autowired
    PersonajeDTOService servicio;

    @GetMapping("/personajes/search")
    public List<PersonajeDTO> findCharacters(@RequestParam String name){
        return servicio.searchAllByName(name);
    }

    @GetMapping("/personajes")
    public List<PersonajeDTO> findAll(){
        return servicio.searchAll();
    }

    @PostMapping("/personajes")
    public ResponseEntity<String> uploadCharacters(@RequestBody List<PersonajeEntity> personajes){
        servicio.addAll(personajes);
        return new ResponseEntity<>("Se agregaron correctamente!", HttpStatus.OK);
    }

}
