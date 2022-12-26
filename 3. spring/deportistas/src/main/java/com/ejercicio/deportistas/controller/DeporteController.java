package com.ejercicio.deportistas.controller;

import com.ejercicio.deportistas.dto.PersonDto;
import com.ejercicio.deportistas.model.Deporte;
import com.ejercicio.deportistas.model.Persona;
import com.ejercicio.deportistas.service.DeporteService;
import com.ejercicio.deportistas.service.PersonasService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/findSports")
public class DeporteController {

    private DeporteService deporteService;
    private PersonasService personasService;

    public DeporteController() {
        this.deporteService = new DeporteService();
        this.personasService = new PersonasService();
    }

    @GetMapping
    public List<Deporte> mostrarDeportes(){
        return deporteService.todos();
    }
    @GetMapping(value ={"/{nombreDeporte}"})
    public List<Deporte> todos(
            @PathVariable String nombreDeporte) {
        return deporteService.obrenerDeportePorNombre(nombreDeporte);
    }

    @GetMapping("/findSportsPersons")
    public List<PersonDto> mostrarDeportistas(){
        List<Persona> personas = personasService.devuelvePersona();
        return personas.stream().map(p->{
            return new PersonDto(p.getNombre(),p.getApellido(),p.getDeporte().getNombre());
        }).collect(Collectors.toList());

    }

}
