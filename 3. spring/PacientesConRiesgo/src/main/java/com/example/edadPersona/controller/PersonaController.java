package com.example.edadPersona.controller;

import com.example.edadPersona.DTO.PersonaDTO;
import com.example.edadPersona.entity.Persona;
import com.example.edadPersona.entity.Sintoma;
import com.example.edadPersona.service.PersonaService;
import com.example.edadPersona.service.SintomaService;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/covid")
public class PersonaController {
    SintomaService sintomaService = new SintomaService();
    PersonaService personaService = new PersonaService();

    public PersonaController() {
    }

    public PersonaController(SintomaService sintomaService, PersonaService personaService) {
        this.sintomaService = sintomaService;
        this.personaService = personaService;
    }
    @GetMapping("/findSymptom")
    public List<Sintoma> getSintomas(){
        return sintomaService.sintomaList();
    }
    @GetMapping("/findSymptom/{name}")
    ResponseEntity<Sintoma> getSintoma(@PathVariable String name){
        return sintomaService.getSintoma(name)
                .map(value->new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(()->new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/findPacients")
    public List<Persona> getPacientes(){
        return personaService.getPersonaList();
    }
    @GetMapping("/riskPacients")
    ResponseEntity<List<PersonaDTO>> getPersonasRiesgo(){
        return new ResponseEntity<>(personaService.getPersonasConRiesgo(), HttpStatus.OK);
    }
}
