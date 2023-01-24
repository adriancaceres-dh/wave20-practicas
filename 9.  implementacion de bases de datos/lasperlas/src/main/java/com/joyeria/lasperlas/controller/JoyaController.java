package com.joyeria.lasperlas.controller;

import com.joyeria.lasperlas.model.Joya;
import com.joyeria.lasperlas.service.IJoyaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/jewelry")
public class JoyaController {

    private final IJoyaService joyaService;

    public JoyaController(IJoyaService joyaService) {
        this.joyaService = joyaService;
    }

    @PostMapping("/new")
    public ResponseEntity<String> addJoya(@RequestBody Joya joya) {
        return new ResponseEntity<>(joyaService.addJoya(joya), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<Joya>> getJoyas() {

        return new ResponseEntity<>(joyaService.getJoyas(), HttpStatus.OK);
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<String> deleteJoya(@PathVariable Long id) {

        return new ResponseEntity<>(joyaService.inactivateJoya(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> editJoya(@PathVariable Long id,
                                           @RequestBody Joya joya) {

        return new ResponseEntity<>(joyaService.editJoya(id, joya), HttpStatus.OK);
    }
}
