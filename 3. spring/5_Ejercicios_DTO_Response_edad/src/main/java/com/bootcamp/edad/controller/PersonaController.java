package com.bootcamp.edad.controller;

import com.bootcamp.edad.service.PersonaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class PersonaController {

    private PersonaService personaService;

    public PersonaController(){
        personaService = new PersonaService();
    }
    @GetMapping("/{dia}/{mes}/{ano}")
    public int edad(@PathVariable int dia, @PathVariable int mes, @PathVariable int ano){
        return personaService.calcularEdad(dia,mes,ano);
    }

}
