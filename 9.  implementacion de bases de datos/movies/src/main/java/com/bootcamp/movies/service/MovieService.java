package com.bootcamp.movies.service;

import com.bootcamp.movies.dto.response.SimpleMovieDto;
import com.bootcamp.movies.repository.ActorMovieRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService implements IMovieService{

    private final ActorMovieRepository actorMovieRepository;
    private final ModelMapper modelMapper;

    public MovieService(ActorMovieRepository actorMovieRepository, ModelMapper modelMapper) {
        this.actorMovieRepository = actorMovieRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<SimpleMovieDto> findMoviesWhichActorsHasRatingAbove(Double aboveRating) {
        return actorMovieRepository.findMoviesWhichActorsHasRatingAbove(aboveRating)
                .stream()
                .map(movie -> modelMapper.map(movie, SimpleMovieDto.class))
                .collect(Collectors.toList());
    }
}
