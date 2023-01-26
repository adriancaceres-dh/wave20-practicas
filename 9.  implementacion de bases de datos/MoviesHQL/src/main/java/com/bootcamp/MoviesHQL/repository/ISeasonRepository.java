package com.bootcamp.MoviesHQL.repository;

import com.bootcamp.MoviesHQL.model.Season;
import com.bootcamp.MoviesHQL.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ISeasonRepository extends JpaRepository<Season, Integer> {
    @Query("SELECT DISTINCT sea.serie FROM Season sea WHERE sea.serie.id > :seasonNumber")
    List<Serie> findSerieBySeasonNumber(Integer seasonNumber);
}
