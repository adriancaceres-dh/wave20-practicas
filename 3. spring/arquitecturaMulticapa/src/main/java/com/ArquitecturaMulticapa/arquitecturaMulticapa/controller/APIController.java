package com.ArquitecturaMulticapa.arquitecturaMulticapa.controller;
import com.ArquitecturaMulticapa.arquitecturaMulticapa.dto.CharacterDto;
import com.ArquitecturaMulticapa.arquitecturaMulticapa.repository.ICharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class APIController {
    @Autowired
    private ICharacterRepository repository;
    @GetMapping("/{criteria}")
    public List<CharacterDto> busquedaPorCriteria(@PathVariable String criteria){
        return repository.findAllByNameContains(criteria);
    }

}

