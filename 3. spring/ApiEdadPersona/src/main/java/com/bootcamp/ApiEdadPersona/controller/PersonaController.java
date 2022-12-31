package com.bootcamp.ApiEdadPersona.controller;

import com.bootcamp.ApiEdadPersona.services.PersonaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Period;

@RestController
public class PersonaController {
    @GetMapping("/{dia}/{mes}/{ano}")
    public ResponseEntity<Integer> edadPersona(@PathVariable int dia, @PathVariable int mes, @PathVariable int ano){
        return  new ResponseEntity<>(PersonaService.getEdad(dia,mes,ano),HttpStatus.BAD_REQUEST);

    }
    @GetMapping("/estado")
    ResponseEntity<String> respuesta(){
        return  new ResponseEntity<>("bien hecho",  HttpStatus.OK);
    }
}
