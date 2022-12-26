package com.bootcamp.Covid19.controlador;

import com.bootcamp.Covid19.servicios.EnfermedadServicios;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Enfermedad {

    EnfermedadServicios es = new EnfermedadServicios();
    @GetMapping(value = {"/findSymptom","/findSymptom/{name}"})
    public ResponseEntity enfermedades(@PathVariable (required = false) String name){


        return es.enfermedades(name);
    }
    @GetMapping(value = {"/findRiskPerson"})
    public ResponseEntity enfermedadPorPersona(){

        return es.enfermedadPorPersona();
    }
}
