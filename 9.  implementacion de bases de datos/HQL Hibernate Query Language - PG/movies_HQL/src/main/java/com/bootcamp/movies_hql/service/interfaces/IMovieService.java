package com.bootcamp.movies_hql.service.interfaces;


import com.bootcamp.movies_hql.dto.response.MovieDTO;
import com.bootcamp.movies_hql.service.interfaces.generics.ICrudService;

import java.util.List;

public interface IMovieService extends ICrudService<MovieDTO, Long> {

    // Listar todas las películas cuyos actores tengan rating superior a <valor recibido por parámetro>
    List<MovieDTO> getMoviesWithRatingHigherThan(double rating);

    // Listar todas las películas que pertenezcan al <género recibido por parámetro>
    List<MovieDTO> getMoviesWithGenreEqualsThan(String genre);

}
