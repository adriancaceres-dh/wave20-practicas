package com.bootcamp.movies_hql.service.actor;

import com.bootcamp.movies_hql.dto.ActorDTO;

import java.util.Set;

public interface IActorService {

    Set<ActorDTO> getActorsByFavoriteMovieNotNull();
    Set<ActorDTO> getActorsByRatingGreaterThan(Double rating);
    Set<ActorDTO> getActorsByMovieWorkedIn(Integer movieId);
}
