package com.example.JoyeriaLasPerlas.controller;

import com.example.JoyeriaLasPerlas.model.Joya;
import com.example.JoyeriaLasPerlas.service.IJoyaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JoyaController {
    @Autowired
    IJoyaService joyaService;

    @PostMapping("/jewelry/new")
    public String saveJoya(@RequestBody Joya joya) {
        return joyaService.saveJoya(joya);
    }
    @GetMapping("/jewelry")
    public List<Joya> getAllJoyas() {
        return joyaService.getJoyas();
    }
    @PutMapping("/jewelry/delete/{id}")
    public String deleteJoya(@PathVariable Long id) {
        return joyaService.deleteJoya(id);
    }
    @PutMapping("/jewelry/update/{id}")
    public String updateJoya(@RequestBody Joya joya, @PathVariable Long id) {
        return joyaService.editJoya(joya, id);
    }

}
