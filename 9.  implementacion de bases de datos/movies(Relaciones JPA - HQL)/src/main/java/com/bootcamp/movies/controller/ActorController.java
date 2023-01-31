package com.bootcamp.movies.controller;

import com.bootcamp.movies.repository.IActorRepository;
import com.bootcamp.movies.service.interfaces.IActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.parser.Entity;

@RestController
@RequestMapping("/actors")
public class ActorController {

    @Autowired
    private IActorService actorService;

    @GetMapping("/withFavoriteMovie")
    public ResponseEntity<?> getActorsWithFavoriteMovie(){
        return ResponseEntity.ok().body(actorService.getActorsWithFavortiteMovie());
    }

    @GetMapping("/withRatingGreaterThan/{rating}")
    public ResponseEntity<?> getActorsWithFavoriteMovie(@PathVariable Double rating){
        return ResponseEntity.ok().body(actorService.getActorsWhooseRatingIsGreaterThan(rating));
    }

    @GetMapping("/movie/{movieId}")
    public ResponseEntity<?> getActorsWithFavoriteMovie(@PathVariable Integer movieId){
        return ResponseEntity.ok().body(actorService.getActorsOfMovie(movieId));
    }
}
