package com.bootcamp.movies.service.interfaces;

import com.bootcamp.movies.dto.response.SimpleEpisodeDto;

import java.util.List;

public interface IEpisodeService {
    List<SimpleEpisodeDto> getEpisodesWhichActorParticipated(Integer actorId);
}
