package com.bootcamp.Deportistas.controller;

import com.bootcamp.Deportistas.dto.PersonaDTO;
import com.bootcamp.Deportistas.service.DeporteService;
import com.bootcamp.Deportistas.service.PersonaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/findSportsPerson")
public class PersonaController {

    private PersonaService personaService;

    public PersonaController(){
        personaService = new PersonaService();
    }

    @GetMapping("/{deporte}")
    public ResponseEntity<List<PersonaDTO>> encontrarDeportistas(@PathVariable String deporte){
        return new ResponseEntity<>(personaService.encontrarDeportistas(deporte), HttpStatus.OK);

    }
}
