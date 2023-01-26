package com.example.Practica.HQL.controller;

import com.example.Practica.HQL.model.Actor;
import com.example.Practica.HQL.service.interfaces.IActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/actors")
public class ActorController {

    @Autowired
    IActorService iActorService;

    @GetMapping("")
    public ResponseEntity<List<Actor>> findAll(@RequestParam(required = false) boolean favMovie,
                                               @RequestParam(required = false) Double rating,
                                               @RequestParam(required = false) Integer movieId){
        return ResponseEntity.ok(iActorService.findAll(favMovie, rating, movieId));
    }


}
