package com.bootcamp.movies.service;

import com.bootcamp.movies.dto.EpisodeDto;
import com.bootcamp.movies.repository.ActorEpisodeRepository;
import com.bootcamp.movies.service.interfaces.IEpisodeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EpisodeService implements IEpisodeService {
    private final ActorEpisodeRepository actorEpisodeRepository;

    private final ModelMapper modelMapper;

    public EpisodeService(ActorEpisodeRepository actorEpisodeRepository, ModelMapper modelMapper) {
        this.actorEpisodeRepository = actorEpisodeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<EpisodeDto> findAllEpisodesWithActorAppearance(Integer actorId) {
        return actorEpisodeRepository.findAllEpisodesWithActorAppearance(actorId)
                .stream()
                .map(episode -> modelMapper.map(episode, EpisodeDto.class))
                .collect(Collectors.toList());
    }
}
