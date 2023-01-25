package com.bootcamp.movies_hql.controller;

import com.bootcamp.movies_hql.dto.MovieDTO;
import com.bootcamp.movies_hql.service.movie.IMovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final IMovieService movieService;

    public MovieController(IMovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/actor_rating/{rating}")
    ResponseEntity<Set<MovieDTO>> getMoviesByActorsAverageRatingGreaterThan(@PathVariable Double rating) {
        return ResponseEntity.status(HttpStatus.OK).body(movieService.getMoviesByActorRatingGreaterThan(rating));
    }

    @GetMapping("/genre/{genreId}")
    ResponseEntity<Set<MovieDTO>> getMoviesByGenreIdEquals(@PathVariable Integer genreId) {
        return ResponseEntity.status(HttpStatus.OK).body(movieService.getMoviesByGenreIdEquals(genreId));
    }

    @GetMapping("/actor_count/{count}")
    ResponseEntity<Set<MovieDTO>> getMoviesByActorCountGreaterThan(@PathVariable Integer count) {
        return ResponseEntity.status(HttpStatus.OK).body(movieService.getMoviesByActorCountGreaterThan(count));
    }
}
