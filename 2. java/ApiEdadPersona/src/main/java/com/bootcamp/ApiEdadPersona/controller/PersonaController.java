package com.bootcamp.ApiEdadPersona.controller;

import com.bootcamp.ApiEdadPersona.services.PersonaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Period;

@RestController
public class PersonaController {
    @GetMapping("/{dia}/{mes}/{ano}")
    public int edadPersona(@PathVariable int dia, @PathVariable int mes, @PathVariable int ano){
        return PersonaService.getEdad(dia,mes,ano);
    }
}
