package com.example.starwars.controller;

import com.example.starwars.dto.PersonajeDTO;
import com.example.starwars.service.StarWarsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StarwarsController {
    StarWarsService starWarsService;
    public StarwarsController() {
        starWarsService=new StarWarsService();
    }

    @GetMapping("/personajes")
    public ResponseEntity<List<PersonajeDTO>> searchCharacter(@RequestParam String name){

        return new ResponseEntity<>(starWarsService.consulta(name), HttpStatus.ACCEPTED);
    }

}
