package com.bootcamp._vivo_dto.controller;


import com.bootcamp._vivo_dto.model.Persona;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class getEdadController {

    @GetMapping("/{dia}/{mes}/{anio}")
    public int getEdad(@PathVariable int dia,
                        @PathVariable int mes,
                        @PathVariable int anio){
        return Persona.calcularEdad(dia,mes,anio);

    }
}
