package com.bootcamp.movies_hql.service.movie;

import com.bootcamp.movies_hql.dto.MovieDTO;

import java.util.Set;

public interface IMovieService {

    Set<MovieDTO> getMoviesByActorRatingGreaterThan(Double rating);
    Set<MovieDTO> getMoviesByGenreIdEquals(Integer genreId);
    Set<MovieDTO> getMoviesByActorCountGreaterThan(Integer count);
}
