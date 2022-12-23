package com.edadPersona.edadpersona.controller;

import com.edadPersona.edadpersona.services.EdadService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EdadPersonaController {

    @GetMapping("/{dia}/{mes}/{ano}")
    public String obtenerEdadPersona(@PathVariable String dia, @PathVariable String mes, @PathVariable String ano){
        return EdadService.calcularEdadPersona(dia, mes, ano);
    }

}
