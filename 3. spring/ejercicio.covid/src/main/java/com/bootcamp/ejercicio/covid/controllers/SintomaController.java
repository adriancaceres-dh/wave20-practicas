package com.bootcamp.ejercicio.covid.controllers;


import com.bootcamp.ejercicio.covid.dto.PersonaDTO;
import com.bootcamp.ejercicio.covid.models.Sintoma;
import com.bootcamp.ejercicio.covid.services.interfaces.ISintomaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SintomaController
{
    private final ISintomaService sintomaService;

    public SintomaController(ISintomaService sintomaService) {
        this.sintomaService = sintomaService;
    }


    @GetMapping(path = "/findSymptom")
    public List<Sintoma> buscarSintomas(){
        return sintomaService.buscarSintomas();
    }

    @GetMapping(path = "/findSymptom/{nombre}")
    public ResponseEntity buscarSintomas(@PathVariable String nombre){
       if(sintomaService.buscarSintoma(nombre).isPresent()){
           return ResponseEntity.ok(sintomaService.buscarSintoma(nombre).get());

       }else {
           return (ResponseEntity) ResponseEntity.badRequest().body("No se encontro este sintoma");
       }
    }

     @GetMapping(path = "/findRiskPerson")
    public List<PersonaDTO> buscarPersonasDeRiesgo(){
        return sintomaService.buscarPersonasDeRiesgo();
     }

}
