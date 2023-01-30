package com.bootcamp.movies.service;

import com.bootcamp.movies.dto.SeasonDto;
import com.bootcamp.movies.dto.SerieDto;
import com.bootcamp.movies.repository.SerieRepository;
import com.bootcamp.movies.service.interfaces.ISerieService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SerieService implements ISerieService {
    private final SerieRepository serieRepository;
    private final ModelMapper modelMapper;

    public SerieService(SerieRepository serieRepository, ModelMapper modelMapper) {
        this.serieRepository = serieRepository;
        this.modelMapper = modelMapper;
    }

    public List<SerieDto> findAllSeriesWhenHaveMoreSeasonsThan(Integer amountOfSeasons) {
        return serieRepository.findAllSeriesWhenHaveMoreSeasonsThan(amountOfSeasons)
                .stream()
                .map(serie -> modelMapper.map(serie, SerieDto.class))
                .collect(Collectors.toList());
    }

}
