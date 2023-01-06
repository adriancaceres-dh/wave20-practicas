package com.bootcamp.entidad_de_salud.controller;

import com.bootcamp.entidad_de_salud.dto.PersonaDto;
import com.bootcamp.entidad_de_salud.models.Sintoma;
import com.bootcamp.entidad_de_salud.models.Persona;
import com.bootcamp.entidad_de_salud.services.Services;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EntidadSaludController {

    private Services services;

    public EntidadSaludController(){
        services = new Services();
    }

    @GetMapping("/findSymptom")
    @ResponseBody
    public List<Sintoma> obtenerSintomas(){
        return services.obtenerSintomas();
    }

    @GetMapping("/findSymptom/{nombre}")
    public ResponseEntity<String> obtenerGravedad(@PathVariable String nombre){
        String gravedadSintoma = services.obtenerGravedadDelSintoma(nombre);
        if(gravedadSintoma == null) return ResponseEntity.badRequest().body("No se encontro el sintoma");
        return ResponseEntity.ok().body(gravedadSintoma);
    }

    @GetMapping("/findRiskPerson")
    public List<PersonaDto> obtenerGravedad(){
        return services.grupoDeRiesgo();
    }

}
