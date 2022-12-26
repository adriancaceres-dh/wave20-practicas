package com.bootcamp.DtoResponseEntity.controller;

import com.bootcamp.DtoResponseEntity.model.Persona;
import com.bootcamp.DtoResponseEntity.service.PersonaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PersonaController {

    private PersonaService personaService;

    public PersonaController() {
        personaService = new PersonaService();
    }
    //sin terminar
    @GetMapping("/findRiskPerson")
    public ResponseEntity<Object> listaPersonasConSimtoma(@RequestParam String nombre){
        return personaService.listaDePersonasConSintoma(nombre);
    }
    @GetMapping("/listPerson")
    public ResponseEntity<Object> listaPersonas(){
        return personaService.listaDePeronas();
    }
    //sin terminar
    @PostMapping("/savePersona")
    public ResponseEntity<Object> guardarPersona(@RequestBody Persona persona){
        return personaService.guardarPersona(persona);
    }
}
