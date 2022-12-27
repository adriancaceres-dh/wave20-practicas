package com.bootcamp.Starwars.controller;

import com.bootcamp.Starwars.DTO.CharacterDTO;
import com.bootcamp.Starwars.service.CharacterServices;
import com.bootcamp.Starwars.service.ICharacterServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class CharacterController {
    @Autowired
    ICharacterServices icharacterServices;
  //  public CharacterController(){
  //      characterServices = new CharacterServices();
  //  }

    @GetMapping("/characters/")
    public ResponseEntity<List<CharacterDTO>> getCharacters(){
        return new ResponseEntity<>(icharacterServices.getCharacters(), HttpStatus.OK);
    }

    @GetMapping("/characters/{characterName}")
    public ResponseEntity<List<CharacterDTO>> getCharacters(@PathVariable String characterName){
        if (characterName != null) return new ResponseEntity<>(icharacterServices.getCharacters(characterName), HttpStatus.OK);
        return new ResponseEntity<>(icharacterServices.getCharacters(), HttpStatus.OK);

    }

}

