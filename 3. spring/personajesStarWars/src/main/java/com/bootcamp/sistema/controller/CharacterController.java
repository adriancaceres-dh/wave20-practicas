package com.bootcamp.sistema.controller;

import com.bootcamp.sistema.dto.CharacterDTO;
import com.bootcamp.sistema.service.ICharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CharacterController {

    @Autowired
    ICharacterService characterService;

    @GetMapping("/search/{name}")
    public List<CharacterDTO> findAllByName(@PathVariable String name){
        return characterService.findAllByName(name);
    }
}
