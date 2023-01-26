package com.bootcamp.movies.service;

import com.bootcamp.movies.dto.response.SimpleMovieDto;

import java.util.List;

public interface IMovieService {
    List<SimpleMovieDto> findMoviesWhichActorsHasRatingAbove(Double aboveRating);
    List<SimpleMovieDto> findMoviesWhichGenreIs(Integer genreId);
}
