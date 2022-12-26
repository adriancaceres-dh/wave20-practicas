package com.bootcamp.starwars.Star.wars.controller;

import com.bootcamp.starwars.Star.wars.dto.CharacterDTO;
import com.bootcamp.starwars.Star.wars.entity.Personaje;
import com.bootcamp.starwars.Star.wars.repository.PersonajeRepository;
import com.bootcamp.starwars.Star.wars.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class Controller {
    @Autowired
    PersonajeRepository personajeRepository;

    @GetMapping("/personajes/{name}")
    public ResponseEntity<List<CharacterDTO>> getAllCharacters(@PathVariable String name){
        List<CharacterDTO> finalCharacters = personajeRepository.getPersonajeRepository().stream()
                .filter(character -> character.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());

        return ResponseEntity.ok().body(finalCharacters);
    }
}
