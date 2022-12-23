package com.example.obtener_edad_api.controllers;

import com.example.obtener_edad_api.service.EdadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class IndexController {
    @Autowired
    EdadService edadService;

    @GetMapping("edad/{dia}/{mes}/{anno}")
    public int edad(
            @PathVariable int dia,
            @PathVariable int mes,
            @PathVariable int anno
    ){
        return edadService.calcularEdad(dia,mes,anno);

    }
}
