package com.bootcamp.movies_hql.repository;

import com.bootcamp.movies_hql.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IMovieRepository extends JpaRepository<Movie, Long> {

    // Listar todas las películas cuyos actores tengan rating superior a <valor recibido por parámetro>
    List<Movie> findMovieByActorsRatingGreaterThan(double rating);

    // Listar todas las películas que pertenezcan al <género recibido por parámetro>
    List<Movie> findMovieByGenreNameLike(String name);
}
