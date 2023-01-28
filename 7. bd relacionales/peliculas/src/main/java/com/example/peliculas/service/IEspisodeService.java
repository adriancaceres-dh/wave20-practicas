package com.example.peliculas.service;

import com.example.peliculas.dto.EpisodeDto;

import java.util.List;

public interface IEspisodeService {

    List<EpisodeDto> findEpisodesByActor(String name);
}
