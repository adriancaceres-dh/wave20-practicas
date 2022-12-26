package com.bootcamp._dto_p2.controller;

import com.bootcamp._dto_p2.dto.PersonaDTO;
import com.bootcamp._dto_p2.model.Persona;
import com.bootcamp._dto_p2.repository.PersonaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class PersonaController {

    @PostMapping("/personas")
    public ResponseEntity<String> agregarPersonas(@RequestBody List<Persona> personas){
        boolean ok= PersonaRepository.addAll(personas);
        if(ok){return new ResponseEntity<>("Personas agregadas!", HttpStatus.OK);}
        else{return new ResponseEntity<>("No se pudo agregar personas :(",HttpStatus.CONFLICT);}
    }

    @GetMapping("/personas")
    public List<PersonaDTO> mostrarPersonas(){
        return PersonaRepository.getAll().stream()
                .map(persona -> new PersonaDTO(persona.getNombre(), persona.getApellido()))
                .collect(Collectors.toList());
    }

}
