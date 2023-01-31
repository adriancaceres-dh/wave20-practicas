package com.bootcamp.movies.service.impl;

import com.bootcamp.movies.dto.MovieDTO;
import com.bootcamp.movies.entity.Movie;
import com.bootcamp.movies.repository.IGenresRepository;
import com.bootcamp.movies.repository.IMoviesRepository;
import com.bootcamp.movies.service.interfaces.IMovieService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements IMovieService {

    @Autowired
    private IMoviesRepository moviesRepository;


    private ModelMapper mapper = new ModelMapper();

    @Override
    public List<MovieDTO> getMoviesOfAGenre(Integer genreId) {
        List<Movie> movies = moviesRepository.findByGenre(genreId);
        return movies.stream().map(m -> mapper.map(m, MovieDTO.class)).collect(Collectors.toList());
    }
}
