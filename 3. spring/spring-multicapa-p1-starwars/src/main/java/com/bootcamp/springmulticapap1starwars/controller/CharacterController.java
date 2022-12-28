package com.bootcamp.springmulticapap1starwars.controller;

import com.bootcamp.springmulticapap1starwars.dto.response.CharacterResponseDTO;
import com.bootcamp.springmulticapap1starwars.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CharacterController {
    @Autowired
    private CharacterService characterService;

    @GetMapping("/filter/{query}")
    public List<CharacterResponseDTO> filterBy(@PathVariable String query) {
        return characterService.filterBy(query);
    }
}
