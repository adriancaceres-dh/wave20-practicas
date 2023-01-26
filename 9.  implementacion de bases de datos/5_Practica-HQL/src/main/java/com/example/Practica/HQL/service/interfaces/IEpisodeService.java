package com.example.Practica.HQL.service.interfaces;

import com.example.Practica.HQL.model.Episode;

import java.util.List;

public interface IEpisodeService {

    List<Episode> findAll(String actorName);
}
