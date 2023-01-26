package com.bootcamp.MoviesHQL.service;

import com.bootcamp.MoviesHQL.dto.response.ActorResponseDTO;
import com.bootcamp.MoviesHQL.dto.response.MovieResponseDTO;
import com.bootcamp.MoviesHQL.model.Actor;
import com.bootcamp.MoviesHQL.model.Movie;

import java.util.List;

public interface IActorService {
    List<ActorResponseDTO> findActorByMovie();
    List<ActorResponseDTO> findActorByRating(Double rating);

    List<ActorResponseDTO> findActorByMovieTitle(String movie);

}
