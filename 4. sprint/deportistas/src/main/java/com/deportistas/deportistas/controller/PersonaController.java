package com.deportistas.deportistas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deportistas.deportistas.dto.response.ListaPersonasYDeportesDto;
import com.deportistas.deportistas.services.PersonaService;

@RestController
@RequestMapping("/person")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping("/findSportPersons")
    public List<ListaPersonasYDeportesDto> listaTodasLasPersonas() {
        return personaService.listaDePersonas();
    }
}
