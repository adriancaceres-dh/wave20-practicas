package com.starwars.starwarsCharacters.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.starwars.starwarsCharacters.dtoresponse.CharactersDtoResponse;
import com.starwars.starwarsCharacters.service.StarwarsService;

@RestController
public class StarwarsController {

    @Autowired
    private StarwarsService starwarsService;

    @GetMapping("/findCharacter/{name}")
    public List<CharactersDtoResponse> findCharacters(@PathVariable String name) {
        return starwarsService.findCharacters(name);
    }
}
