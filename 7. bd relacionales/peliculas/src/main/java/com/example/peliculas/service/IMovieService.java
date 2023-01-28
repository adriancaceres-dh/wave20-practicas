package com.example.peliculas.service;

import com.example.peliculas.dto.ActorDto;
import com.example.peliculas.dto.MovieDto;
import com.example.peliculas.entity.Movie;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IMovieService {

    List<ActorDto> findActorsByMovie(String name);

    List<MovieDto> findMoviesByGenre(String name);

    List<MovieDto> findByMovie( Double rating);

}
