package com.bootcamp.movies.service;

import com.bootcamp.movies.dto.response.SimpleEpisodeDto;
import com.bootcamp.movies.repository.ActorEpisodeRepository;
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
    public List<SimpleEpisodeDto> getEpisodesWhichActorParticipated(Integer actorId) {
        return actorEpisodeRepository.findAllEpisodesWhichWorkedActor(actorId)
                .stream()
                .map(e -> modelMapper.map(e, SimpleEpisodeDto.class))
                .collect(Collectors.toList());
    }
}
