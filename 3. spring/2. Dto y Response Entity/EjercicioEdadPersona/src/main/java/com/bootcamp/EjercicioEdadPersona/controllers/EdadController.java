package com.bootcamp.EjercicioEdadPersona.controllers;

import com.bootcamp.EjercicioEdadPersona.services.CalculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class EdadController {

    @Autowired
    CalculoService calculoService;
    @GetMapping("/{dia}/{mes}/{ano}")
    public ResponseEntity calculoEdad(@PathVariable int dia,
                                      @PathVariable int mes,
                                      @PathVariable int ano){
        String edad = this.calculoService.calcularEdad(ano,mes,dia).toString();
        return ResponseEntity.ok().body(edad);
    }
}
