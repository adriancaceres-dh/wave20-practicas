package com.bootcamp.movies.service;

import com.bootcamp.movies.dto.response.SimpleEpisodeDto;

import java.util.List;

public interface IEpisodeService {
    List<SimpleEpisodeDto> getEpisodesWhichActorParticipated(Integer actorId);
}
