package com.bootcamp._vivo_dto_ej2.controller;


import com.bootcamp._vivo_dto_ej2.model.Persona;
import com.bootcamp._vivo_dto_ej2.repository.PersonaRepository;
import com.bootcamp._vivo_dto_ej2.view.PersonaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class PersonaController {

    @PostMapping("/personas")
    public ResponseEntity<Boolean>  addPersona(@RequestBody Persona persona){
        Boolean ok = PersonaRepository.addPersona(persona);
        return new ResponseEntity<>(ok, (ok)? HttpStatus.OK : HttpStatus.INSUFFICIENT_SPACE_ON_RESOURCE);
    }

    @GetMapping("/personas")
    public ResponseEntity<List<PersonaDTO>> getPersonas(){
        List<PersonaDTO> personasDTO = PersonaRepository.getAll().stream()
                .map(persona -> new PersonaDTO(persona.getNombre(),persona.getApellido(),persona.getEdad()))
                .collect(Collectors.toList());
        return new ResponseEntity<>(personasDTO,HttpStatus.OK);
    }

}
