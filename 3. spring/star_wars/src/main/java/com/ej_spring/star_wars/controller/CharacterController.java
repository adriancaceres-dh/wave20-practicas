package com.ej_spring.star_wars.controller;

import com.ej_spring.star_wars.service.CharacterService;
import com.ej_spring.star_wars.dto.CharacterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class CharacterController {

    @Autowired
    public CharacterService characterService;

    @GetMapping("/charactersByName/{name}")
    public List<CharacterDto> charactersByName(@PathVariable String name) {
        return this.characterService.charactersByName(name);
    }
}
