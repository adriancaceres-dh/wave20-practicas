package com.wave20.ejercicio_covid19.controller;

import com.wave20.ejercicio_covid19.dto.PersonaSintomaDTO;
import com.wave20.ejercicio_covid19.dto.SintomaDTO;
import com.wave20.ejercicio_covid19.service.PersonaService;
import com.wave20.ejercicio_covid19.service.SintomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class Controller {

    @Autowired
    SintomaService sintomaService;

    @Autowired
    PersonaService personaService;

    @GetMapping("/findSymptom")
    public ResponseEntity<List<SintomaDTO>> getSintomas() {
        return new ResponseEntity<>(sintomaService.getSintomas(), HttpStatus.OK);
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<String> getSintomas(@PathVariable String name) {
        Optional<SintomaDTO> s = sintomaService.getSintomaPorNombre(name);
        if (s.isPresent()) {
            return new ResponseEntity<>(s.get().getNivel_gravedad(),
                    HttpStatus.OK);

        } else {
            return new ResponseEntity<>("No se encontró sintoma con ese nombre", HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<PersonaSintomaDTO>> getPersonasConSintomas() {
        return new ResponseEntity<>(PersonaService.getPersonasConSintomas(), HttpStatus.OK);
    }



}
