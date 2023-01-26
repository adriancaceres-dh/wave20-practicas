package com.example.moviesrelaciones.repository;

import com.example.moviesrelaciones.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IActorRepository extends JpaRepository<Actor,Integer> {

}
