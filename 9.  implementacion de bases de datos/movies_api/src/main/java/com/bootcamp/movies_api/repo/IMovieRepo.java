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

      //@Query("from Movie m inner join m.cast a WHERE :rating > a.rating")
     // @Query("select distinct m from Movie m WHERE :rating < all elements(m.cast.rating)")
     // @Query("select distinct m from Movie m  join m.cast a WHERE :rating < all elements(a.rating)")
    //  @Query("select distinct m from Movie m WHERE :rating < all (select a.rating from Movie m2 join m.cast a where m.id = m2.id)")
      //@Query("from Movie m INNER JOIN m.cast actor WHERE :rating < ALL( select subA.rating from Movie subM INNER JOIN m.cast subA where subM.id = m.id)")
   /* @Query(value="SELECT m.* FROM movies m \n" +
            "inner join actor_movie am \n" +
            "on m.id = am.movie_id \n" +
            "inner join actors a \n" +
            "on a.id = am.actor_id \n" +
            "where 5.5 < ALL(\n" +
            "\tselect a2.rating from movies m2 \n" +
            "\tinner join actor_movie am2\n" +
            "\ton m2.id = am2.movie_id \n" +
            "\tinner join actors a2 \n" +
            "\ton a2.id = am2.actor_id \n" +
            "    where m2.id = m.id);", nativeQuery = true)*/
    //@Query("SELECT DISTINCT m FROM Movie m JOIN m.cast a WHERE :rating < ALL (SELECT a2.rating FROM a.movies m2 JOIN m2.cast a2)")
      List<Movie> findByCastRatingGreaterThan(@Param("rating") Double rating);
   // findByCastRatingGreaterThan
      List<Movie> findByGenreNameIs(@Param("genre") String genre);
}
