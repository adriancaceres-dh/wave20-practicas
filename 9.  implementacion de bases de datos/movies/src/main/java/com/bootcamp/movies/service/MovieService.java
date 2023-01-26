package com.bootcamp.movies.service;

import com.bootcamp.movies.dto.response.SimpleMovieDto;
import com.bootcamp.movies.repository.ActorMovieRepository;
import com.bootcamp.movies.repository.MovieRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService implements IMovieService {

    private final ActorMovieRepository actorMovieRepository;
    private final MovieRepository movieRepository;
    private final ModelMapper modelMapper;

    public MovieService(ActorMovieRepository actorMovieRepository, MovieRepository movieRepository, ModelMapper modelMapper) {
        this.actorMovieRepository = actorMovieRepository;
        this.movieRepository = movieRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<SimpleMovieDto> findMoviesWhichActorsHasRatingAbove(Double aboveRating) {
        return actorMovieRepository.findMoviesWhichActorsHasRatingAbove(aboveRating)
                .stream()
                .map(movie -> modelMapper.map(movie, SimpleMovieDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<SimpleMovieDto> findMoviesWhichGenreIs(Integer genreId) {
        return movieRepository.findAllByGenreId(genreId)
                .stream()
                .map(movie -> modelMapper.map(movie, SimpleMovieDto.class))
                .collect(Collectors.toList());
    }
}
