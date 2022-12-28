package com.bootcamp.Concesionaria.controller;

import com.bootcamp.Concesionaria.model.Automovil;
import com.bootcamp.Concesionaria.service.AutoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Scanner;

@RestController
@RequestMapping("/V1/api")
public class AutosController {

    @Autowired
    AutoServiceImpl autoService;
    @GetMapping(value = {"/vehicles/","/vehicles/{id}"})
    public ResponseEntity<?> listarAutos(@PathVariable (required = false) String id){

        if(id == null){
            return new ResponseEntity<>(autoService.obtenerListaAutos(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(autoService.obtenerAutoPorId(id), HttpStatus.OK);
        }


    }

    @GetMapping("/vehicles/dates")
    public ResponseEntity<?> listarAutosPorDate(@RequestParam String since, @RequestParam String to){

        return new ResponseEntity<>(autoService.obtenerPorFecha(since, to), HttpStatus.OK);

    }

    @GetMapping("/vehicles/prices")
    public ResponseEntity<?> listarAutosPorPrice(@RequestParam String since, @RequestParam String to){

        return new ResponseEntity<>(autoService.obtenerPorPrice(since, to), HttpStatus.OK);

    }

    @PostMapping("/vehicles/")
    public String guardarAuto(@RequestBody Automovil automovil){


        return autoService.guardarAuto(automovil);

    }


}
