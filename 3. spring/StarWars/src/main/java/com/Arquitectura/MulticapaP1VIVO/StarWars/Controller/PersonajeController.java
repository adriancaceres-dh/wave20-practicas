package com.Arquitectura.MulticapaP1VIVO.StarWars.Controller;

import com.Arquitectura.MulticapaP1VIVO.StarWars.Dto.PersonajeDto;
import com.Arquitectura.MulticapaP1VIVO.StarWars.Dto.PersonajeRetornoDto;
import com.Arquitectura.MulticapaP1VIVO.StarWars.Repository.PersonajeRepository;
import com.Arquitectura.MulticapaP1VIVO.StarWars.Service.PersonajesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonajeController {

    @Autowired
    PersonajesService personajesService;
    PersonajeRetornoDto personajeRetornoDto;

    @GetMapping("/personajes")
    public List<PersonajeDto> getJsonFile()
    {
        return personajesService.encontrarTodos();
    }

    @GetMapping("/todo")
    public  List<PersonajeRetornoDto> todo()
    {
        return personajesService.todos();
    };

    @GetMapping("/buscar/{nombre}")
    public PersonajeDto buscarPorNombre(@PathVariable String nombre)
    {
        return personajesService.buscarPorNombre(nombre);
    }


}
