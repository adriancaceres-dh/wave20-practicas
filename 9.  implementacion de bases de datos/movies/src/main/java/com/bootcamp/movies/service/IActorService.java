package com.bootcamp.movies.service;

import com.bootcamp.movies.dto.response.ActorFavoriteMovieResponseDto;
import com.bootcamp.movies.model.Actor;

import java.util.List;

public interface IActorService {
    List<ActorFavoriteMovieResponseDto> findAllActorsWhichFavoriteMovieIsNotNull();

    List<Actor> findAllActorsWhichRatingExceeds(Double lowerBound);

    List<Actor> findActorsThatWorkedInMovie(Integer movieId);
}
