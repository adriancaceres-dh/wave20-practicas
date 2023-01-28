package com.example.peliculas.service;

import com.example.peliculas.dto.ActorDto;

import java.util.List;

public interface IActorService {

    public List<ActorDto> findByMovieNotNull();

    List<ActorDto> findByating(Double rating);

    List<ActorDto> selectActorsByMovie(String movie);

}
