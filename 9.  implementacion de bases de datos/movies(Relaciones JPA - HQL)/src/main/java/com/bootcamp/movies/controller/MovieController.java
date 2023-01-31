package com.bootcamp.movies.controller;

import com.bootcamp.movies.service.interfaces.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private IMovieService movieService;

    @GetMapping("/genre/{genreId}")
    public ResponseEntity<?> getMoviesOfAGenre(@PathVariable Integer genreId){
        return ResponseEntity.ok().body(movieService.getMoviesOfAGenre(genreId));
    }
}
