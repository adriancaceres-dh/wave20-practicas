package com.hql.movies.service.interfaces;

import com.hql.movies.model.Actor;
import com.hql.movies.model.Movie;
import com.hql.movies.service.interfaces.generics.ICrudService;

import java.util.List;

public interface IMovieService extends ICrudService<Movie, Integer> {
    List<Actor> getActorsInMovie(String movieName);
    List<Movie> getMoviesByGenreId(Integer genreId);
}
