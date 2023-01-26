package com.bootcamp.movies.service;

import com.bootcamp.movies.dto.response.SimpleSerieDto;
import com.bootcamp.movies.repository.SerieRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SerieService implements ISerieService{

    private final SerieRepository serieRepository;
    private final ModelMapper modelMapper;

    public SerieService(SerieRepository serieRepository, ModelMapper modelMapper) {
        this.serieRepository = serieRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<SimpleSerieDto> findSeriesThatHaveMoreSeasonsThat(Integer numberOfSeasons) {
        return serieRepository.findSeriesThatHaveMoreSeasonsThat(numberOfSeasons)
                .stream()
                .map(s -> modelMapper.map(s, SimpleSerieDto.class))
                .collect(Collectors.toList());
    }
}
