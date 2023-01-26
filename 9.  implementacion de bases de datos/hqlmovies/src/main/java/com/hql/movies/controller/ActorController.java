package com.hql.movies.controller;

import com.hql.movies.dto.response.ActorsLikedMoviesDTO;
import com.hql.movies.service.interfaces.IActorService;
import com.hql.movies.dto.response.ActorsRatingDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/actors")
public class ActorController {
    private final IActorService actorService;

    public ActorController(IActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping("/likedMovies")
    public ResponseEntity<ActorsLikedMoviesDTO> getActorsLikedMovies(){
        return new ResponseEntity<>(actorService.getActorsWithLikedMovies(), HttpStatus.OK);
    }
    @GetMapping("/actorByRating{rating}")
    public ResponseEntity<ActorsRatingDTO> getActorsByRating(@RequestParam Double rating){
        return new ResponseEntity<>(actorService.getActorsByRating(rating), HttpStatus.OK);
    }
}
