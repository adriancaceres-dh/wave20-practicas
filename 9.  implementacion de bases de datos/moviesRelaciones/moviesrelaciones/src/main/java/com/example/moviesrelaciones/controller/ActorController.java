package com.example.moviesrelaciones.controller;

import com.example.moviesrelaciones.dto.ActorDTO;
import com.example.moviesrelaciones.service.ActorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ActorController {
    @Autowired
    ActorServiceImpl actorService;
    @GetMapping()
    public ResponseEntity<List<ActorDTO>> getAllActors(){
        return ResponseEntity.ok(actorService.getAllEntities());
    }
}
