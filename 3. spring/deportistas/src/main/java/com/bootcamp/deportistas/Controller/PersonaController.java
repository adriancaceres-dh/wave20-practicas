package com.bootcamp.deportistas.Controller;

import com.bootcamp.deportistas.DTOs.DeportistaDTO;
import com.bootcamp.deportistas.Service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonaController {
    @Autowired
    private IPersonaService personaService;
    @GetMapping("/deportistas")
    public ResponseEntity <List<DeportistaDTO>> deportistas(){
        return ResponseEntity.ok(personaService.getDeportistas());
    }
}
