package com.example.deportistas.controller;

import com.example.deportistas.dto.DeportistaDTO;
import com.example.deportistas.model.Deporte;
import com.example.deportistas.servicio.Deportistas;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeportistasController {
    Deportistas deportistas=new Deportistas();

    @GetMapping(value = {"/findSports","/findSports/{deporte}"})
    public ResponseEntity<List<Deporte>> todosDeportes(@PathVariable(required=false) String deporte){
        return new ResponseEntity<>(deportistas.buscarDeportes(deporte), HttpStatus.OK);
    }

    @GetMapping("/findSportsPersons")
    public List<DeportistaDTO> busarDeportistas(){
        return deportistas.buscarPersonas();
    }

}
