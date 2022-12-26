package com.bootcamp.starwars.controller;

import com.bootcamp.starwars.dto.CharacterDTO;
import com.bootcamp.starwars.service.StarwarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StarwarsController {

    @Autowired
    private StarwarsService starwarsService;

    @GetMapping ("/characters/{nombre}")
    public ResponseEntity<List<CharacterDTO>> findCharacters (@PathVariable String nombre) {
        List<CharacterDTO> resultados = starwarsService.findCharacter(nombre);
        return ResponseEntity.ok(resultados);
    }
}
