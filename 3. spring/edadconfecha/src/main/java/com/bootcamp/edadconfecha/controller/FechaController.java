package com.bootcamp.edadconfecha.controller;

import com.bootcamp.edadconfecha.service.FechaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FechaController {
    FechaService fechaService;

    public FechaController(){
        fechaService = new FechaService();
    }

    @GetMapping("/test")
    public String test(){
        return "Test";
    }
    @GetMapping("/fecha/{dia}/{mes}/{ano}")
    public String parseFechaAEdad(@PathVariable String dia, @PathVariable String mes, @PathVariable String ano){
        return fechaService.fechaAEdad(dia,mes,ano);
    }

}
