package com.bootcamp.movies_hql.service.episode;

import com.bootcamp.movies_hql.dto.EpisodeDTO;

import java.util.Set;

public interface IEpisodeService {

    Set<EpisodeDTO> getEpisodesByActorId(Integer actorId);
}
