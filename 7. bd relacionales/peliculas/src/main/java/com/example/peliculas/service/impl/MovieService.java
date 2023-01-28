package com.example.peliculas.service.impl;

import com.example.peliculas.dto.ActorDto;
import com.example.peliculas.dto.MovieDto;
import com.example.peliculas.entity.Movie;
import com.example.peliculas.repository.IActorRepository;
import com.example.peliculas.repository.IGenreRepository;
import com.example.peliculas.repository.IMovieRepository;
import com.example.peliculas.service.IActorService;
import com.example.peliculas.service.IMovieService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class MovieService implements IMovieService {

    IActorRepository actorRepository;
    IMovieRepository movieRepository;

    IGenreRepository genreRepository;

    ModelMapper modelMapper;

    public MovieService(IActorRepository actorRepository, IMovieRepository movieRepository, IGenreRepository genreRepository) {
        this.actorRepository = actorRepository;
        this.movieRepository = movieRepository;
        this.genreRepository = genreRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public List<ActorDto> findActorsByMovie(String name) {

        List<ActorDto> actors = actorRepository.findActorsByMovie(name)
                .stream().map(a -> modelMapper.map(a,ActorDto.class)).collect(Collectors.toList());
        return actors;
    }

    @Override
    public List<MovieDto> findMoviesByGenre(String name) {
        List<MovieDto> movies = genreRepository.findMoviesByGenre(name)
                .stream().map(a -> modelMapper.map(a,MovieDto.class)).collect(Collectors.toList());
        return movies;
    }

    @Override
    public List<MovieDto> findByMovie(Double rating) {
        List<MovieDto> movies = movieRepository.findByMovie(rating)
                .stream().map(a -> modelMapper.map(a,MovieDto.class)).collect(Collectors.toList());
        return movies;
    }
}
