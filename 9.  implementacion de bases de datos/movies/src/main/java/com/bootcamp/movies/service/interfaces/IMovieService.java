package com.bootcamp.movies.service.interfaces;

import com.bootcamp.movies.dto.MovieDto;

import java.util.List;

public interface IMovieService {

    List<MovieDto> findMoviesWhereActorsHaveRatingSuperiorTo(Double rating);

    List<MovieDto> findAllByGenreName(String genreName);

}
