package com.ejercicio.Covid19.Controller;

import com.ejercicio.Covid19.dto.PersonDto;
import com.ejercicio.Covid19.model.Persona;
import com.ejercicio.Covid19.model.Sintoma;
import com.ejercicio.Covid19.service.PersonaService;
import com.ejercicio.Covid19.service.SintomaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/findSymptom")
public class ControllerService {
    private PersonaService personaService;

    private SintomaService sintomaService;

    public ControllerService(){
        personaService = new PersonaService();
        sintomaService = new SintomaService();
    }

    @GetMapping()
    public List<Sintoma> todos() {
        return sintomaService.getSintomas();
    }

    @GetMapping("/{name}")
    public String nivelDeGravedad(@PathVariable String name){
        return sintomaService.buscarPorNombre(name);
    }

    @GetMapping("/findRiskPerson")
    public List<PersonDto> personasDeRiesgo(){
        return personaService.personasDeRiego().stream().map(p->{return new PersonDto(p.getNombre(), p.getApelliedo());}).collect(Collectors.toList());
    }

}
