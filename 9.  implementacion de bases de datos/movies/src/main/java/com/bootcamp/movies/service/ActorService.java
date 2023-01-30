package com.bootcamp.movies.service;

import com.bootcamp.movies.model.Actor;
import com.bootcamp.movies.repository.ActorMovieRepository;
import com.bootcamp.movies.repository.ActorRepository;
import com.bootcamp.movies.service.interfaces.IActorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService implements IActorService {

    private final ActorRepository actorRepo;
    private final ActorMovieRepository actorMovieRepository;

    public ActorService(ActorRepository actorRepo, ActorMovieRepository actorMovieRepository) {
        this.actorRepo = actorRepo;
        this.actorMovieRepository = actorMovieRepository;
    }

    @Override
    public List<Actor> findAllActorsWhichFavoriteMovieIsNotNull() {
        return actorRepo.findAllByFavoriteMovieIsNotNull();
    }

    @Override
    public List<Actor> findAllActorsWhichRatingExceeds(Double lowerBound) {
        return actorRepo.findAllByRatingGreaterThan(lowerBound);
    }

    @Override
    public List<Actor> findActorsThatWorkedInMovie(Integer movieId) {
        return actorMovieRepository.findActorsThatWorkedInMovie(movieId);
    }


}
