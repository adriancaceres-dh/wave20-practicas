package com.example.edadpersona.controller;

import com.example.edadpersona.model.Persona;
import com.example.edadpersona.service.EdadPersona;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EdadController {

    @GetMapping("/edad/{day}/{month}/{year}")
    public int edadPersona(@PathVariable int day,
                           @PathVariable int month,
                           @PathVariable int year){
        Persona persona=new Persona(day,month,year);
        return EdadPersona.calcular(persona);
    }
}
