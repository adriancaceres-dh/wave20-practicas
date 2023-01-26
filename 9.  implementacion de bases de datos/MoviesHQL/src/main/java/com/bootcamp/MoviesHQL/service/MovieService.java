package com.bootcamp.MoviesHQL.service;

import com.bootcamp.MoviesHQL.dto.response.MovieResponseDTO;
import com.bootcamp.MoviesHQL.repository.IActorMovieRepository;
import com.bootcamp.MoviesHQL.repository.IMovieRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService implements IMovieService{

    private final IMovieRepository movieRepository;

    private final IActorMovieRepository actorMovieRepository;

    ModelMapper modelMapper = new ModelMapper();

    public MovieService(IMovieRepository movieRepository, IActorMovieRepository actorMovieRepository) {
        this.movieRepository = movieRepository;
        this.actorMovieRepository = actorMovieRepository;
    }
    @Override
    public List<MovieResponseDTO> findByGenre(String genre) {
        return movieRepository.findByGenre(genre).stream()
                .map(movie -> modelMapper.map(movie, MovieResponseDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<MovieResponseDTO> findMovieByActorRating(Double rating) {
        return actorMovieRepository.findMovieByActorRating(rating).stream()
                .map(movie -> modelMapper.map(movie, MovieResponseDTO.class)).collect(Collectors.toList());
    }
}
