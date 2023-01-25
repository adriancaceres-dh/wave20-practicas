package com.bootcamp.movies_hql.service.movie;

import com.bootcamp.movies_hql.dto.MovieDTO;
import com.bootcamp.movies_hql.repository.IMovieRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements IMovieService {

    private final IMovieRepository movieRepository;
    ModelMapper modelMapper = new ModelMapper();

    public MovieServiceImpl(IMovieRepository movieRepository) {
        this.movieRepository = movieRepository;

        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
    }

    @Override
    public Set<MovieDTO> getMoviesByActorRatingGreaterThan(Double rating) {
        return movieRepository.findByActorRatingGreaterThan(rating).stream()
                .map(movie -> modelMapper.map(movie, MovieDTO.class)).collect(Collectors.toSet());
    }

    @Override
    public Set<MovieDTO> getMoviesByGenreIdEquals(Integer genreId) {
        return movieRepository.findByGenreIdEquals(genreId).stream()
                .map(movie -> modelMapper.map(movie, MovieDTO.class)).collect(Collectors.toSet());
    }

    @Override
    public Set<MovieDTO> getMoviesByActorCountGreaterThan(Integer count) {
        return movieRepository.findByActorCountGreaterThan(count).stream()
                .map(movie -> modelMapper.map(movie, MovieDTO.class)).collect(Collectors.toSet());
    }
}
