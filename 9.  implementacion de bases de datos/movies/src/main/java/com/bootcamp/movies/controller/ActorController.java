package com.bootcamp.movies.controller;


import com.bootcamp.movies.model.Actor;
import com.bootcamp.movies.service.IActorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/actors")
public class ActorController {
    private final IActorService actorService;

    public ActorController(IActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping("/favorite-not-null")
    public ResponseEntity<List<Actor>> getAllActorsWithFavoriteMovie() {
        return ResponseEntity.ok(actorService.findAllActorsWhichFavoriteMovieIsNotNull());
    }

    @GetMapping("/rating-greater-than/{lowerBound}")
    public ResponseEntity<List<Actor>> getAllActorsWithRatingGraterThan(@PathVariable Double lowerBound) {
        return ResponseEntity.ok(actorService.findAllActorsWhichRatingExceeds(lowerBound));
    }

    @GetMapping("/movie-worked/{movieId}")
    public ResponseEntity<List<Actor>> getActorsThatWorkedInMovie(@PathVariable Integer movieId) {
        return ResponseEntity.ok(actorService.findActorsThatWorkedInMovie(movieId));
    }
}
