package com.example.Practica.HQL.service.interfaces;

import com.example.Practica.HQL.model.Actor;

import java.util.List;

public interface IActorService {
    public List<Actor> findAll(Boolean favMovie, Double rating, Integer movieId);
}
