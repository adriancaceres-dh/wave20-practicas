package com.bootcamp.movies.service.interfaces;

import com.bootcamp.movies.dto.EpisodeDto;

import java.util.List;

public interface IEpisodeService {
    List<EpisodeDto> findAllEpisodesWithActorAppearance(Integer actorId);
}
