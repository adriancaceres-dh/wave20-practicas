package com.bootcamp.MoviesHQL.controller;

import com.bootcamp.MoviesHQL.service.IMovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class MovieController {
    private final IMovieService movieService;

    public MovieController(IMovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/byGenre")
    public ResponseEntity<?> findByGenre(@RequestParam String genre){
        return ResponseEntity.ok(movieService.findByGenre(genre));
    }

    @GetMapping("/byActorRating")
    public ResponseEntity<?> findByGenre(@RequestParam Double rating){
        return ResponseEntity.ok(movieService.findMovieByActorRating(rating));
    }
}
