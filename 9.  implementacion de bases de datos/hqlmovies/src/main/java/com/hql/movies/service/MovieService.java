package com.hql.movies.service;

import com.hql.movies.dto.MessageDTO;
import com.hql.movies.model.Actor;
import com.hql.movies.model.Movie;
import com.hql.movies.repository.IActorMovieRepository;
import com.hql.movies.repository.IMovieRepository;
import com.hql.movies.service.interfaces.IMovieService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService implements IMovieService {
    public MovieService(IMovieRepository movieRepository, IActorMovieRepository actorMovieRepository) {
        this.movieRepository = movieRepository;
        this.actorMovieRepository = actorMovieRepository;
    }

    IMovieRepository movieRepository;
    IActorMovieRepository actorMovieRepository;


    @Override
    public Movie saveEntity(Movie movieDTO) {
        return null;
    }

    @Override
    public Movie getEntityById(Integer integer) {
        return null;
    }

    @Override
    public List<Movie> getAllEntities() {
        return null;
    }

    @Override
    public MessageDTO deleteEntity(Integer integer) {
        return null;
    }

    @Override
    public List<Actor> getActorsInMovie(String movieTitle) {
        return actorMovieRepository.findAllActorsInMovie(movieTitle);
    }
}
