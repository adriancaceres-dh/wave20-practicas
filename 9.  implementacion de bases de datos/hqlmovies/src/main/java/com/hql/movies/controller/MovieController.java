package com.hql.movies.controller;

import com.hql.movies.dto.response.ActorListedDTO;
import com.hql.movies.model.*;
import com.hql.movies.service.interfaces.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    final
    IMovieService movieService;

    public MovieController(IMovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/actorsInMovie{movieName}")
    public ResponseEntity<List<Actor>> getActorsInMovie(@RequestParam String movieName){
        return new ResponseEntity<>(movieService.getActorsInMovie(movieName), HttpStatus.OK);
    }

    @GetMapping("/byGenre{genreID}")
    public ResponseEntity<List<Movie>> getMoviesByGenreID(@RequestParam Integer genreId){
        return new ResponseEntity<>(movieService.getMoviesByGenreId(genreId), HttpStatus.OK);
    }
}
