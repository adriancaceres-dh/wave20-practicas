package com.bootcamp.Hospital.controller;


import com.bootcamp.Hospital.dto.SintomaDto;
import com.bootcamp.Hospital.model.Persona;
import com.bootcamp.Hospital.model.Sintoma;
import com.bootcamp.Hospital.response.ResponseEntity;
import com.bootcamp.Hospital.service.PersonaService;
import com.bootcamp.Hospital.service.SintomaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/persona")
public class PersonaController {


    private PersonaService personaService = new PersonaService();

    @PostMapping("/savePerson")
    public ResponseEntity<Persona> savePerson(@RequestBody Persona persona){
        return personaService.savePerson(persona);
    }

    @GetMapping("findAllPerson")
    public ResponseEntity<List<SintomaDto>> findAllPerson(){
        return personaService.findAllPerson();
    }
    @GetMapping("findPerson/{id}")
    public ResponseEntity<Persona> findPerson(@PathVariable String id){
        return personaService.findPerson(id);
    }


}
