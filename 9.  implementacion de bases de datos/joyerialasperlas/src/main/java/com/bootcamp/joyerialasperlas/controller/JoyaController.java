package com.bootcamp.joyerialasperlas.controller;

import com.bootcamp.joyerialasperlas.dto.JoyaRequestDTO;
import com.bootcamp.joyerialasperlas.model.Joya;
import com.bootcamp.joyerialasperlas.service.IJoyaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.lang.annotation.Repeatable;
import java.util.List;

@RestController
@RequestMapping("/jewelry")
public class JoyaController {

    IJoyaService joyaService;

    public JoyaController(IJoyaService joyaService) {
        this.joyaService = joyaService;
    }

    @PostMapping("/new")
    public ResponseEntity<Integer> createJoya(@RequestBody JoyaRequestDTO joya) {
        return new ResponseEntity<>(joyaService.crearJoya(joya), HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<Joya>> getAlljoyas() {
        return new ResponseEntity<>(joyaService.getAllJoyas(), HttpStatus.OK);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<String> deleteJoya(@PathVariable Integer id) {
        return new ResponseEntity<>(joyaService.deleteJoya(id), HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Joya> updateJoya(@RequestBody JoyaRequestDTO joya, @PathVariable Integer id) {
        return new ResponseEntity<>(joyaService.updateJoya(joya, id), HttpStatus.OK);
    }

}
