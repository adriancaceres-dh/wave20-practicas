package com.bootcamp.movies_api.controller;

import com.bootcamp.movies_api.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("movies")
public class MoviesController {
    @Autowired
    MovieService service;

    @GetMapping("{title}/cast-members")
    public ResponseEntity<?> getCastMembersFromMovie(@PathVariable String title){
        return new ResponseEntity<>(service.getCastMembersFromMovie(title), HttpStatus.OK);
    }

    //BETA y TEST
    @GetMapping("cast-members-all-over/{rating}")
    public ResponseEntity<?> getMovieWithCastRatingOver(@PathVariable Double rating){
        return new ResponseEntity<>(service.getMovieWithCastRatingOver(rating), HttpStatus.OK);
    }
    @GetMapping("genre/{genre}")
    public ResponseEntity<?> getMovieWithCastRatingOver(@PathVariable String genre){
        return new ResponseEntity<>(service.getMoviesByGenre(genre), HttpStatus.OK);
    }

}
