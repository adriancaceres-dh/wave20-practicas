package com.bootcamp.starwars.controller;

import com.bootcamp.starwars.dto.response.CharacterDtoResponse;
import com.bootcamp.starwars.model.CharacterModel;
import com.bootcamp.starwars.service.CharacterServiceImpl;
import com.bootcamp.starwars.service.ICharacterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CharacterController {

    ICharacterService characterService = new CharacterServiceImpl();

    @GetMapping("/{query}")
    public ResponseEntity<List<CharacterDtoResponse>> findAllCharactersThatMatch(@PathVariable String query) {
        return new ResponseEntity(characterService.charactersThatMatch(query),HttpStatus.OK);
    }
}
