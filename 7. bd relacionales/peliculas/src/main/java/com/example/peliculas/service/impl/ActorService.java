package com.example.peliculas.service.impl;

import com.example.peliculas.dto.ActorDto;
import com.example.peliculas.repository.IActorRepository;
import com.example.peliculas.repository.IMovieRepository;
import com.example.peliculas.service.IActorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActorService implements IActorService {

    @Autowired
    IActorRepository actorRepository;

    @Autowired
    IMovieRepository movieRepository;

    ModelMapper modelMapper;

    public ActorService(IActorRepository actorRepository) {
        this.actorRepository = actorRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public List<ActorDto> findByMovieNotNull() {

        List<ActorDto> actors = actorRepository.findActorByFavoriteMovieIsNotNull()
                  .stream().map(a -> modelMapper.map(a, ActorDto.class)).collect(Collectors.toList());
        return actors;
    }

    @Override
    public List<ActorDto> findByating(Double rating) {

        List<ActorDto> actors = actorRepository.findActorByRatingGreaterThan(rating)
                .stream().map(a -> modelMapper.map(a, ActorDto.class)).collect(Collectors.toList());
        return actors;
    }

    @Override
    public List<ActorDto> selectActorsByMovie(String movie) {
        List<ActorDto> actors = actorRepository.findActorsByMovie(movie)
                .stream().map(a -> modelMapper.map(a,ActorDto.class)).collect(Collectors.toList());
        return actors;
    }
}
