package com.bootcamp.movies.service.interfaces;

import com.bootcamp.movies.dto.MovieDTO;

import java.util.List;

public interface IMovieService {

    List<MovieDTO> getMoviesOfAGenre(Integer genreId);
}
