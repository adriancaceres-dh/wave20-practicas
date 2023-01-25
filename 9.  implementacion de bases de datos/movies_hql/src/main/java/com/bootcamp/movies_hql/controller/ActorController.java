package com.bootcamp.movies_hql.controller;

import com.bootcamp.movies_hql.dto.ActorDTO;
import com.bootcamp.movies_hql.service.actor.IActorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/actors")
public class ActorController {

    private final IActorService actorService;

    public ActorController(IActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping("favorite_movie_not_null")
    public ResponseEntity<Set<ActorDTO>> getActorsByFavoriteMovieNotNull() {
        return ResponseEntity.status(HttpStatus.OK).body(actorService.getActorsByFavoriteMovieNotNull());
    }

    @GetMapping("/rating/{rating}")
    public ResponseEntity<Set<ActorDTO>> getActorsByRatingGreaterThan(@PathVariable Double rating) {
        return ResponseEntity.status(HttpStatus.OK).body(actorService.getActorsByRatingGreaterThan(rating));
    }

    @GetMapping("/movie/{movieId}")
    public ResponseEntity<Set<ActorDTO>> getActorsByMovieWorkedIn(@PathVariable Integer movieId) {
        return ResponseEntity.status(HttpStatus.OK).body(actorService.getActorsByMovieWorkedIn(movieId));
    }
}
