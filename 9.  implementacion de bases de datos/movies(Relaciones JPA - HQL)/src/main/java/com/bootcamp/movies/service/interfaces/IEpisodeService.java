package com.bootcamp.movies.service.interfaces;

import com.bootcamp.movies.dto.EpisodeDTO;

import java.util.List;

public interface IEpisodeService {

    List<EpisodeDTO> getEpisodesOf(Integer actorId);
}
