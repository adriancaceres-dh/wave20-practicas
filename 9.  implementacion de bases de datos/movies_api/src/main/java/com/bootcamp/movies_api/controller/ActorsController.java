package com.bootcamp.movies_api.controller;

import com.bootcamp.movies_api.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("actors")
public class ActorsController {
    @Autowired
    ActorService service;

    @GetMapping("have-selected-favorite-movie")
    public ResponseEntity<?> getAllActorsWithSelectedFavoriteMovie(){
        return new ResponseEntity<>(service.getActorsWithFavMovies(), HttpStatus.OK);
    }
    @GetMapping("rating-equal-or-over/{rating}")
    public ResponseEntity<?> getAllActorsWithRatingGreaterThanEqual(@PathVariable Double rating){
        return new ResponseEntity<>(service.getActorsWithRatingGreaterThanEqual(rating), HttpStatus.OK);
    }



}
