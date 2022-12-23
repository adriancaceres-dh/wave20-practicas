package com.dto.deportistas.controller;

import com.dto.deportistas.service.DeportistaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/findSportPersons")
public class DeportistaController {

    DeportistaService deportistaService;

    public DeportistaController(){
        deportistaService = new DeportistaService();
    }

    @GetMapping
    public String leerDeportistas(){
        return deportistaService.toString();
    }

}
