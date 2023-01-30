package com.hql.movies.controller;

import com.hql.movies.dto.response.ActorListedDTO;
import com.hql.movies.model.Actor;
import com.hql.movies.service.interfaces.IActorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/actors")
public class ActorController {
    private final IActorService actorService;

    public ActorController(IActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping("/likedMovies")
    public ResponseEntity<ActorListedDTO> getActorsLikedMovies(){
        return new ResponseEntity<>(actorService.getActorsWithLikedMovies(), HttpStatus.OK);
    }
    @GetMapping("/actorByRating{rating}")
    public ResponseEntity<ActorListedDTO> getActorsByRating(@RequestParam Double rating){
        return new ResponseEntity<>(actorService.getActorsByRatingHQL(rating), HttpStatus.OK);
    }

}
