package com.example.personajes.controllers;

import com.example.personajes.dtos.CharacterDto;
import com.example.personajes.services.IStarWarsCharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/character")
public class StarWarsCharacterControll {

    @Autowired
    IStarWarsCharacterService _service;
    @GetMapping()
    public Collection<CharacterDto> findByName(@RequestParam String name){
        return  _service.findByName(name);
    }

}
