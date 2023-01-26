package com.bootcamp.MoviesHQL.service;

import com.bootcamp.MoviesHQL.dto.response.MovieResponseDTO;
import com.bootcamp.MoviesHQL.model.Movie;

import java.util.List;

public interface IMovieService {
    List<MovieResponseDTO> findByGenre(String genre);

    List<MovieResponseDTO> findMovieByActorRating (Double rating);
}
