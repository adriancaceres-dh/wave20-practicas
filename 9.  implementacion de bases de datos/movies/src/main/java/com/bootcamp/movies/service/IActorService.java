package com.bootcamp.movies.service;

import com.bootcamp.movies.model.Actor;

import java.util.List;

public interface IActorService {
    List<Actor> findAllActorsWhichFavoriteMovieIsNotNull();

    List<Actor> findAllActorsWhichRatingExceeds(Double lowerBound);

    List<Actor> findActorsThatWorkedInMovie(Integer movieId);
}
