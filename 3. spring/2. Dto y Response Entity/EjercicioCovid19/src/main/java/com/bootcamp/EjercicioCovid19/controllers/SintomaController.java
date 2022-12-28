package com.bootcamp.EjercicioCovid19.controllers;

import com.bootcamp.EjercicioCovid19.DTOs.SintomaDto;
import com.bootcamp.EjercicioCovid19.services.PersonaService;
import com.bootcamp.EjercicioCovid19.services.SintomaService;
import com.bootcamp.EjercicioCovid19.DTOs.PersonaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SintomaController {

    @Autowired
    SintomaService sintomaService;
    @Autowired
    PersonaService personaService;
    @GetMapping("/findSymptom")
    public ResponseEntity<List<SintomaDto>> obtenerSintomas(){

        return ResponseEntity.ok().body(sintomaService.getSintomas());
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<SintomaDto> busquedaSintoma(@PathVariable String name){

        return ResponseEntity.ok().body(sintomaService.busquedaSintoma(name));
    }

    @GetMapping ("/findRiskPerson")
    public ResponseEntity<List<PersonaDto>> evaluaRiesgo (){

        return ResponseEntity.ok().body(personaService.getListadoRiesgo());
    }
}
