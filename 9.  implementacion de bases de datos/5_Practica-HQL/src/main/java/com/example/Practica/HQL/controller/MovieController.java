package com.example.Practica.HQL.controller;

import com.example.Practica.HQL.model.Actor;
import com.example.Practica.HQL.model.Movie;
import com.example.Practica.HQL.service.interfaces.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    IMovieService iMovieService;

    @GetMapping("")
    public ResponseEntity<List<Movie>> findAll(@RequestParam(required = false) Integer genreId,
                                               @RequestParam(required = false) Double rating){
        return ResponseEntity.ok(iMovieService.findAll(rating,genreId));
    }
}
