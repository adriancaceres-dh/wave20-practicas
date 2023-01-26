package com.example.Practica.HQL.service.interfaces;

import com.example.Practica.HQL.model.Movie;

import java.util.List;

public interface IMovieService {

    List<Movie> findAll(Double rating, Integer genreId);
}
