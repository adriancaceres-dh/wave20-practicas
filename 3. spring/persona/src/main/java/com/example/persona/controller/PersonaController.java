package com.example.persona.controller;

import com.example.persona.model.dtos.PersonaConDeporteDto;
import com.example.persona.services.PersonaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Persona")
public class PersonaController {
    private static PersonaService _servicio= new PersonaService();
    @GetMapping public List<PersonaConDeporteDto> ObtenerPersonasConSusDeportes(){
        return _servicio.ObtenerPersonasConSusDeportes();
    }



}
