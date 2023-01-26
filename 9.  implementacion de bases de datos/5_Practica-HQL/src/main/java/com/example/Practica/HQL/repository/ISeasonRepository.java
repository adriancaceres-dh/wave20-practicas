package com.example.Practica.HQL.repository;

import com.example.Practica.HQL.model.Season;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISeasonRepository extends JpaRepository<Season,Integer> {

}
