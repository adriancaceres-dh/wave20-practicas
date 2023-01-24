package com.bootcamp.joyeria.controller;

import com.bootcamp.joyeria.dtos.JoyaDto;
import com.bootcamp.joyeria.service.IJoyaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewerly")
public class JoyaController {

    @Autowired
    private IJoyaService joyaService;

    @PostMapping("/new")
    public ResponseEntity<String> crearJoya(@RequestBody JoyaDto joyaDto) {
        return ResponseEntity.ok("Se creó la joya satisfactoriamente con el id: " + joyaService.saveJoya(joyaDto));
    }

    @GetMapping("")
    public ResponseEntity<List<JoyaDto>> listarJoyas() {
        return ResponseEntity.ok(joyaService.getJoyas());
    }
}
