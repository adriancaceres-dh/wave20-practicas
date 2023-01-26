package com.bootcamp.MoviesHQL.service;

import com.bootcamp.MoviesHQL.dto.response.ActorResponseDTO;
import com.bootcamp.MoviesHQL.dto.response.MovieResponseDTO;
import com.bootcamp.MoviesHQL.model.Actor;
import com.bootcamp.MoviesHQL.repository.IActorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActorService implements IActorService{
    private final IActorRepository actorRepository;

    ModelMapper modelMapper = new ModelMapper();

    public ActorService(IActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @Override
    public List<ActorResponseDTO> findActorByMovie() {
        return actorRepository.findActorByMovieIsNotNull().stream()
                .map(actor -> modelMapper.map(actor, ActorResponseDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<ActorResponseDTO> findActorByRating(Double rating) {
        return actorRepository.findActorByRatingGreaterThan(rating).stream()
                .map(actor -> modelMapper.map(actor, ActorResponseDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<ActorResponseDTO> findActorByMovieTitle(String movie) {
        return actorRepository.findActorByMovieTitleEquals(movie).stream()
                .map(actor -> modelMapper.map(actor, ActorResponseDTO.class)).collect(Collectors.toList());
    }
}
