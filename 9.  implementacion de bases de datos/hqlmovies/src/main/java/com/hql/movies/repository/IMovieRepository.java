package com.hql.movies.repository;

import com.hql.movies.model.Actor;
import com.hql.movies.model.Movie;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMovieRepository extends JpaRepository<Movie, Integer> {
    List<Movie> findMoviesByTitle(String title);

    List<Movie> findMovieByGenreId(Integer genreId);
}
