package com.bootcamp.movies.controller;

import com.bootcamp.movies.dto.MovieDto;
import com.bootcamp.movies.service.interfaces.IMovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final IMovieService movieService;

    public MovieController(IMovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/actor-rating-greater-than/{lowerBound}")
    public ResponseEntity<List<MovieDto>> getAllMoviesWhichActorsHaveRatingGreaterThan(@PathVariable Double lowerBound) {
        return ResponseEntity.ok(movieService.findMoviesWhereActorsHaveRatingSuperiorTo(lowerBound));
    }

    @GetMapping("/genre/{genreName}")
    public ResponseEntity<List<MovieDto>> getAllMoviesByGenreName (@PathVariable String genreName) {
        return ResponseEntity.ok(movieService.findAllByGenreName(genreName));
    }
}
