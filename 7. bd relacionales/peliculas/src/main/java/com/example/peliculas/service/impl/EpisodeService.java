package com.example.peliculas.service.impl;

import com.example.peliculas.dto.EpisodeDto;
import com.example.peliculas.repository.IEpisodeRepository;
import com.example.peliculas.service.IEspisodeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EpisodeService implements IEspisodeService {

    IEpisodeRepository episodeRepository;

    ModelMapper modelMapper;

    public EpisodeService(IEpisodeRepository episodeRepository) {
        this.episodeRepository = episodeRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public List<EpisodeDto> findEpisodesByActor(String name) {

        List<EpisodeDto> episodes = episodeRepository.findEpisodesByActor(name)
                .stream().map(e -> modelMapper.map(e , EpisodeDto.class)).collect(Collectors.toList());

        return episodes;
    }
}
