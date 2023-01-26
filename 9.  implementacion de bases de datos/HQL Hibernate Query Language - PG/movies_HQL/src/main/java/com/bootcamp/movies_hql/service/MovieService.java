package com.bootcamp.movies_hql.service;

import com.bootcamp.movies_hql.dto.response.MovieDTO;
import com.bootcamp.movies_hql.entity.Movie;
import com.bootcamp.movies_hql.exception.NotFoundException;
import com.bootcamp.movies_hql.repository.IGenreRepository;
import com.bootcamp.movies_hql.repository.IMovieRepository;
import com.bootcamp.movies_hql.service.interfaces.IMovieService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService implements IMovieService {

    @Autowired
    IMovieRepository movieRepository;

    @Autowired
    IGenreRepository genreRepository;

    private final ModelMapper mapper = new ModelMapper();

    public MovieService() {
        mapper.getConfiguration()
                .setFieldMatchingEnabled(true);
    }

    @Override
    public MovieDTO saveEntity(MovieDTO crudDTO) {
        var entity = mapper.map(crudDTO, Movie.class);

        var entityGenre = genreRepository.findById(crudDTO.getGenre().getId()).get();

        entity.setGenre(entityGenre);

        entity = movieRepository.save(entity);

        return mapper.map(entity, MovieDTO.class);
    }

    @Override
    public MovieDTO getEntityById(Long id) {
        if (!movieRepository.existsById(id)) {
            throw new NotFoundException("Esa película no existe.");
        }
        Movie movie = movieRepository.findById(id).get();
        return mapper.map(movie, MovieDTO.class);
    }

    @Override
    public List<MovieDTO> getAllEntities() {
        return movieRepository.findAll().stream().map(m -> mapper.map(m, MovieDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public String deleteEntity(Long id) {
        if (!movieRepository.existsById(id)) {
            throw new NotFoundException("Esa película no existe.");
        }
        Movie movie = movieRepository.findById(id).get();
        String title = movie.getTitle();
        movieRepository.deleteById(id);
        return "Se ha eliminado la película: " + title;
    }


    @Override
    public List<MovieDTO> getMoviesWithRatingHigherThan(double rating) {
        return movieRepository.findMovieByActorsRatingGreaterThan(rating).stream().map(m -> mapper.map(m, MovieDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<MovieDTO> getMoviesWithGenreEqualsThan(String genre) {
        return movieRepository.findMovieByGenreNameLike(genre).stream().map(m -> mapper.map(m, MovieDTO.class))
                .collect(Collectors.toList());
    }
}
