package com.hql.movies.service.interfaces;

import com.hql.movies.dto.response.ActorListedDTO;
import com.hql.movies.model.Actor;
import com.hql.movies.service.interfaces.generics.ICrudService;

public interface IActorService extends ICrudService<Actor, Integer> {
    ActorListedDTO getActorsWithLikedMovies();

    ActorListedDTO getActorsByRating(Double rating);
    ActorListedDTO getActorsByRatingHQL(Double rating);
}
