package com.bootcamp.PersonajesStarWars.Controller;

import com.bootcamp.PersonajesStarWars.DTO.PersonajesDto;
import com.bootcamp.PersonajesStarWars.Services.IPersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class EncontrarPersonajeController {
    @Autowired
    IPersonajeService servicio;

    @GetMapping("/{nombreCoincidencia}")
    public List<PersonajesDto> encontrarCoincidencias(@PathVariable String nombreCoincidencia){
        return servicio.PersonajeEncontrarSegunNombre(nombreCoincidencia);
    }
}
