package com.bootcamp.movies.controller;

import com.bootcamp.movies.dto.response.SimpleMovieDto;
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

    @GetMapping("/actors-rating-above/{rating}")
    public ResponseEntity<List<SimpleMovieDto>> getMoviesWhichActorsRatingAreAbove(@PathVariable Double rating) {
        return ResponseEntity.ok(movieService.findMoviesWhichActorsHasRatingAbove(rating));
    }

    @GetMapping("/filter-by-genre/{genreId}")
    public ResponseEntity<List<SimpleMovieDto>> getMoviesWhichGenreIs(@PathVariable Integer genreId) {
        return ResponseEntity.ok(movieService.findMoviesWhichGenreIs(genreId));
    }
}
