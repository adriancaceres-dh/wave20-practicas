package com.example.Practica.HQL.repository;

import com.example.Practica.HQL.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGenreRepository extends JpaRepository<Genre,Integer> {

}
