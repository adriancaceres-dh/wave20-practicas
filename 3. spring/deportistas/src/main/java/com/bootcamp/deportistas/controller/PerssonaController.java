package com.bootcamp.deportistas.controller;

import com.bootcamp.deportistas.dto.response.DeportistasResponseDto;
import com.bootcamp.deportistas.service.PersonaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PerssonaController {

    private PersonaService personaService;

    public PerssonaController() {
        personaService = new PersonaService();
    }

    @GetMapping("/deportistas")
    public ResponseEntity<List<DeportistasResponseDto>> deportistas() {
        return new ResponseEntity<>(personaService.getDeportistas(), HttpStatus.OK);
    }
}
