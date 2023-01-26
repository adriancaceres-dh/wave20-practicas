package com.bootcamp.MoviesHQL.service;

import com.bootcamp.MoviesHQL.dto.response.EpisodeResponseDTO;

import java.util.List;

public interface IEpisodeService {

    List<EpisodeResponseDTO> findEpisodeByActor(String firstName, String lastName);
}
