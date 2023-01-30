package com.bootcamp.movies.service;

import com.bootcamp.movies.dto.MovieDto;
import com.bootcamp.movies.repository.ActorMovieRepository;
import com.bootcamp.movies.repository.ActorRepository;
import com.bootcamp.movies.repository.MovieRepository;
import com.bootcamp.movies.service.interfaces.IMovieService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService implements IMovieService {

    private final MovieRepository movieRepo;
    private final ActorMovieRepository actorMovieRepository;

    private final ModelMapper mapper;

    public MovieService(MovieRepository movieRepo, ActorMovieRepository actorMovieRepository, ModelMapper mapper) {
        this.movieRepo = movieRepo;
        this.actorMovieRepository = actorMovieRepository;
        this.mapper = mapper;
    }


    @Override
    public List<MovieDto> findMoviesWhereActorsHaveRatingSuperiorTo(Double rating) {
        return actorMovieRepository.findMoviesWhereActorsHaveRatingSuperiorTo(rating).stream()
                .map(movie -> mapper.map(movie, MovieDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<MovieDto> findAllByGenreName(String genreName) {
        return movieRepo.findAllByGenreName(genreName).stream()
                .map(movie -> mapper.map(movie, MovieDto.class))
                .collect(Collectors.toList());
    }

}
