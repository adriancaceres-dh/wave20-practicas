package com.bootcamp.movies_hql.repository;

import com.bootcamp.movies_hql.entity.Episode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IEpisodeRepository extends JpaRepository<Episode, Long> {

    // Listar todos los episodios (de cualquier serie) donde trabaja un <actor recibido por parámetro>
    List<Episode> findEpisodeByActorsFirstNameEquals(String name);
}
