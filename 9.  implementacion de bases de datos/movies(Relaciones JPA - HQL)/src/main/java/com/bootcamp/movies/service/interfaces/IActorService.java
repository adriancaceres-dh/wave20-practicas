package com.bootcamp.movies.service.interfaces;

import com.bootcamp.movies.dto.ActorDTO;
import com.bootcamp.movies.entity.Actor;

import java.util.List;

public interface IActorService {
    List<ActorDTO> getActorsWithFavortiteMovie();
    List<ActorDTO> getActorsWhooseRatingIsGreaterThan(Double rating);

    List<ActorDTO> getActorsOfMovie(Integer movieId);
}
