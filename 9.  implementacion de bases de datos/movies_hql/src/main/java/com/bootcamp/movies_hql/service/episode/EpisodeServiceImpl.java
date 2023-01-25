package com.bootcamp.movies_hql.service.episode;

import com.bootcamp.movies_hql.dto.EpisodeDTO;
import com.bootcamp.movies_hql.repository.IEpisodeRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EpisodeServiceImpl implements IEpisodeService {

    private final IEpisodeRepository episodeRepository;
    ModelMapper modelMapper = new ModelMapper();

    public EpisodeServiceImpl(IEpisodeRepository episodeRepository) {
        this.episodeRepository = episodeRepository;

        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
    }

    @Override
    public Set<EpisodeDTO> getEpisodesByActorId(Integer actorId) {
        return episodeRepository.findByActorId(actorId).stream()
                .map(episode -> modelMapper.map(episode, EpisodeDTO.class)).collect(Collectors.toSet());
    }
}
