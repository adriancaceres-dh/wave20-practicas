package com.bootcamp.MoviesHQL.service;

import com.bootcamp.MoviesHQL.dto.response.EpisodeResponseDTO;
import com.bootcamp.MoviesHQL.repository.IActorEpisodeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EpisodeService implements IEpisodeService {

    private final IActorEpisodeRepository actorEpisodeRepository;

    ModelMapper modelMapper = new ModelMapper();

    public EpisodeService(IActorEpisodeRepository actorEpisodeRepository) {
        this.actorEpisodeRepository = actorEpisodeRepository;
    }

    @Override
    public List<EpisodeResponseDTO> findEpisodeByActor(String firstName, String lastName) {
        return actorEpisodeRepository.findEpisodeByActor(firstName, lastName).stream()
                .map(episode -> modelMapper.map(episode, EpisodeResponseDTO.class)).collect(Collectors.toList());
    }
}
