package com.bootcamp.MoviesHQL.controller;

import com.bootcamp.MoviesHQL.service.IActorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/actor")
public class ActorController {

    private final IActorService actorService;

    public ActorController(IActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping("/WithFavoriteMovie")
    public ResponseEntity<?> findAllActorWithFavoriteMovie(){
        return ResponseEntity.ok(actorService.findActorByMovie());
    }

    @GetMapping("/byRating")
    public ResponseEntity<?> findAllActorWithFavoriteMovie(@RequestParam Double rating){
        return ResponseEntity.ok(actorService.findActorByRating(rating));
    }

    @GetMapping("/byMovieTitle")
    public ResponseEntity<?> findAllActorByMovieTitle(@RequestParam String movie){
        return ResponseEntity.ok(actorService.findActorByMovieTitle(movie));
    }
}
