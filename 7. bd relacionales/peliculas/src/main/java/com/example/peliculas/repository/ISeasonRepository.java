package com.example.peliculas.repository;

import com.example.peliculas.entity.Season;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISeasonRepository extends JpaRepository<Season,Long> {
}
