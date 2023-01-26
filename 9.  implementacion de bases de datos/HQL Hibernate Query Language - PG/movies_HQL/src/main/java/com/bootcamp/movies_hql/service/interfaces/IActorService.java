package com.bootcamp.movies_hql.service.interfaces;


import com.bootcamp.movies_hql.dto.response.ActorDTO;
import com.bootcamp.movies_hql.entity.Actor;
import com.bootcamp.movies_hql.service.interfaces.generics.ICrudService;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IActorService extends ICrudService<ActorDTO, Long> {

    // Listar todos los actores que tengan declarada una película favorita.
    List<ActorDTO> getActorsWithFavoriteMovie();

    //Listar todos los actores que tengan rating superior a <valor recibido por parámetro>
    List<ActorDTO> getActorsWithRatingGreaterThan(double rating);

    //Listar todos los actores que trabajan en la <película recibida por parámetro>
    List<ActorDTO> getActorsWithMovieNameEquals(String title);

}
