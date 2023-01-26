package com.example.Practica.HQL.service.interfaces;

import com.example.Practica.HQL.model.Serie;

import java.util.List;

public interface ISerieService {

    List<Serie> findAll(Integer cantSeasons);
}
