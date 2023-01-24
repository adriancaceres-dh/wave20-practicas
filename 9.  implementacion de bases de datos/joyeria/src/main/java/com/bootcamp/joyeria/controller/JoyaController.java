package com.bootcamp.joyeria.controller;

import com.bootcamp.joyeria.dtos.JoyaDto;
import com.bootcamp.joyeria.service.IJoyaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jewerly")
public class JoyaController {

    @Autowired
    private IJoyaService joyaService;

    @PostMapping("/new")
    public ResponseEntity<String> crearJoya(@RequestBody JoyaDto joyaDto) {
        return ResponseEntity.ok("Se creó la joya satisfactoriamente con el id: " + joyaService.saveJoya(joyaDto));
    }
}
