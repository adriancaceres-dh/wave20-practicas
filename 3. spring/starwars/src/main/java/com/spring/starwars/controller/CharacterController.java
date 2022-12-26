package com.spring.starwars.controller;

import com.spring.starwars.dto.CharacterDTO;
import com.spring.starwars.service.ICharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/character")
public class CharacterController {
    @Autowired
    public ICharacterService characterService;
    @GetMapping("/findCharacters")
    public ResponseEntity<List<CharacterDTO>> findCharacters(@RequestParam String name){
        return new ResponseEntity<>(characterService.characterByName(name), HttpStatus.OK);
    }

}
