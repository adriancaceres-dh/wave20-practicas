package com.example.Practica.HQL.service;

import com.example.Practica.HQL.model.Movie;
import com.example.Practica.HQL.repository.IMovieRepository;
import com.example.Practica.HQL.service.interfaces.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService implements IMovieService {

    @Autowired
    IMovieRepository iMovieRepository;

    public List<Movie> findAll(Double rating, Integer genreId){
        if(rating!=null&&genreId!=null)
            return iMovieRepository.findByRatingGreaterThanAndGenreIdEquals(rating, genreId);
        else if(rating!=null)
            return iMovieRepository.findByRatingGreaterThan(rating);
        else if(genreId!=null)
            return iMovieRepository.findByGenreIdEquals(genreId);
        else
            return iMovieRepository.findAll();
    }
}
