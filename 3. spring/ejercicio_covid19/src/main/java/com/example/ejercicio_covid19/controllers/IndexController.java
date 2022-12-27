package com.example.ejercicio_covid19.controllers;

import com.example.ejercicio_covid19.dto.response.PersonaEnRiesgoResponseDto;
import com.example.ejercicio_covid19.dto.response.SintomaResponseDto;
import com.example.ejercicio_covid19.repository.RepositorySintoma;
import com.example.ejercicio_covid19.service.PersonaService;
import com.example.ejercicio_covid19.service.SintomaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IndexController {


    SintomaService sintomaService;
    PersonaService personaService;

    public IndexController(){
        sintomaService = new SintomaService();
        personaService = new PersonaService();
    }

    @GetMapping("/findSymtom")
    public ResponseEntity<List<SintomaResponseDto>> findAllSymtoms(){

        return new ResponseEntity<>(sintomaService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/findSymtom/{name}")
    public ResponseEntity<SintomaResponseDto> findSymtomByName(@PathVariable String name){

        return new ResponseEntity<>(sintomaService.findByName(name), HttpStatus.OK);
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<PersonaEnRiesgoResponseDto>> findRiskPersons(){

        return new ResponseEntity<>(personaService.personasEnRiesgo(), HttpStatus.OK);
    }

}
