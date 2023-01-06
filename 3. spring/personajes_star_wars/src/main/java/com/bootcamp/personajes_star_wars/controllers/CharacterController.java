package com.bootcamp.personajes_star_wars.controllers;

import com.bootcamp.personajes_star_wars.dto.CharacterDTO;
import com.bootcamp.personajes_star_wars.services.ICharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CharacterController {
    @Autowired
    private ICharacterService service;

    @GetMapping("/{word}")
    public ResponseEntity<List<CharacterDTO>> findCharacters(@PathVariable String word){
        return ResponseEntity.ok().body(service.find(word));
    }


}
