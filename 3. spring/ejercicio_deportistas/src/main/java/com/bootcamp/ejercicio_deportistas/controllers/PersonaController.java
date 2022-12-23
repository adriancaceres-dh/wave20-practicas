package com.bootcamp.ejercicio_deportistas.controllers;

import com.bootcamp.ejercicio_deportistas.dtos.PersonaDTO;
import com.bootcamp.ejercicio_deportistas.models.Persona;
import com.bootcamp.ejercicio_deportistas.services.interfaces.IDeporteService;
import com.bootcamp.ejercicio_deportistas.services.interfaces.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonaController {

    private final IPersonaService personaService;

    public PersonaController(IPersonaService personaService) {
        this.personaService = personaService;
    }

    @GetMapping(path = "/findSportsPersons")
    public List<PersonaDTO> listarDeportistas(){
        return personaService.buscarDeportistas();
    }
}
