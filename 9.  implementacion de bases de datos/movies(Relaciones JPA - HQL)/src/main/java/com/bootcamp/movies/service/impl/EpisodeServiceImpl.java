package com.bootcamp.movies.service.impl;

import com.bootcamp.movies.dto.EpisodeDTO;
import com.bootcamp.movies.entity.Episode;
import com.bootcamp.movies.repository.IActorEpisodeRepository;
import com.bootcamp.movies.service.interfaces.IEpisodeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EpisodeServiceImpl implements IEpisodeService {

    @Autowired
    private IActorEpisodeRepository actorEpisodeRepository;
    private ModelMapper mapper = new ModelMapper();

    @Override
    public List<EpisodeDTO> getEpisodesOf(Integer actorId) {
        List<Episode> episodes = actorEpisodeRepository.findEpisodesByActor(actorId);
        return episodes.stream().map(e -> mapper.map(e, EpisodeDTO.class)).collect(Collectors.toList());
    }
}
