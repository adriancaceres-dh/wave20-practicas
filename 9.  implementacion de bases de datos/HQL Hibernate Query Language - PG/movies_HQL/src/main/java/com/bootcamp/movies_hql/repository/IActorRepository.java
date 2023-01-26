package com.bootcamp.movies_hql.repository;

import com.bootcamp.movies_hql.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IActorRepository extends JpaRepository<Actor, Long> {

    // Listar todos los actores que tengan declarada una película favorita.
    List<Actor> findActorByFirstNameNotNull();

    //Listar todos los actores que tengan rating superior a <valor recibido por parámetro>
    List<Actor> findActorByRatingGreaterThan(double rating);

    //Listar todos los actores que trabajan en la <película recibida por parámetro>
    @Query("select m.actors from Movie m join m.actors where m.title = :title_movie")
    List<Actor> findActorByMovieEquals(@Param(value = "title_movie") String title);
}
