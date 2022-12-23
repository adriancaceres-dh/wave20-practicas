package com.bootcamp.deportes.controller;

import com.bootcamp.deportes.dto.response.PersonaResponseDto;
import com.bootcamp.deportes.service.PersonaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonaController {
    PersonaService personaService;

    public PersonaController() {
        this.personaService = new PersonaService();
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<PersonaResponseDto>> deportistas(){
        //return new ResponseEntity<>(personaService.personasDeportistas(), HttpStatus.OK);
        return ResponseEntity.ok(personaService.personasDeportistas());
    }
}
