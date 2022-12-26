package com.main.StarWarsApp.controller;


import com.main.StarWarsApp.dtos.CharacterDTO;
import com.main.StarWarsApp.repositories.CharacterRepository;
import com.main.StarWarsApp.services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CharacterController {

    @Autowired
    private CharacterService service;

    @GetMapping(path = "/characters")
    public List<CharacterDTO> findAll(){
        return service.findAll();
    }

    @GetMapping(path = "/characters/{name}")
    public List<CharacterDTO> findAny(@PathVariable String name){
        return service.findAny(name);
    }
}
