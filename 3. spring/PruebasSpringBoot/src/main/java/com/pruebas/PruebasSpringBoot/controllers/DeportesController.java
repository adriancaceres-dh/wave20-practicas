package com.pruebas.PruebasSpringBoot.controllers;


import com.pruebas.PruebasSpringBoot.dto.DeporteDto;
import com.pruebas.PruebasSpringBoot.dto.PersonaDto;
import com.pruebas.PruebasSpringBoot.services.DeportesServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeportesController {


    private DeportesServices deportesServices;

    public DeportesController() {
        deportesServices = new DeportesServices();
    }

    @GetMapping("/findSports")
    public List<DeporteDto> findAllSports(){
        System.out.println(deportesServices.findAllSports());
        return deportesServices.findAllSports();
    }


    @GetMapping("/findSports/{nombre}")
    public ResponseEntity<DeporteDto> findSports(@PathVariable String nombre){
        System.out.println(deportesServices.findSports(nombre));
        return new ResponseEntity<>(deportesServices.findSports(nombre), HttpStatus.OK);
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<PersonaDto>> findSportsPersons(){
        System.out.println(deportesServices.findSportsPerson());
        return new ResponseEntity<>(deportesServices.findSportsPerson(), HttpStatus.OK);
    }
}
