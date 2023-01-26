package com.bootcamp.movies_api.repo;

import com.bootcamp.movies_api.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IMovieRepo extends JpaRepository<Movie, Integer> {
   //Es preferible hacer la consulta por nombre y crear la lista de actores de una peli apartir de la misma
   //o es mejor hacer la consulta por query sql ?
   //@Query("SELET a.cast.first_name, a.cast.last_name FROM Movie WHERE ")
   //List<CastMemberResponseDTO> findCastMembersByTitleIs(@Param("title") String title);

      Movie findByTitleIs(@Param("title") String title);

      List<Movie> findByCastRatingGreaterThan(@Param("rating") Double rating);
      @Query("from Movie m INNER JOIN m.cast actor WHERE actor.rating > :rating")
      List<Movie> findByCastRatingGreaterThanQuery(@Param("rating") Double rating);


    //  @Query("from Movie m INNER JOIN m.cast actor WHERE actor.rating > :rating")
      List<Movie> findByGenreNameIs(@Param("genre") String genre);
}
