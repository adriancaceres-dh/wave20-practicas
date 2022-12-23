package com.bootcamp.edadpersona.controllers;

import com.bootcamp.edadpersona.services.EdadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EdadController {

    @Autowired
    EdadService edadService;





    // Método que solita una edad enviando una fecha
    @GetMapping("/fecha/{dia}/{mes}/{anno}")
    public int getEdad (@PathVariable int dia, @PathVariable int mes, @PathVariable int anno ){
        return edadService.getEdad(dia, mes, anno);
    }
}
