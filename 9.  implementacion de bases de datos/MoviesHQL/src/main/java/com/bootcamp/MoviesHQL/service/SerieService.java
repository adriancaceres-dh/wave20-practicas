package com.bootcamp.MoviesHQL.service;

import com.bootcamp.MoviesHQL.dto.response.SerieResponseDTO;
import com.bootcamp.MoviesHQL.repository.ISerieRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SerieService implements ISerieService{
    private final ISerieRepository serieRepository;
    ModelMapper modelMapper = new ModelMapper();
    public SerieService(ISerieRepository serieRepository) {
        this.serieRepository = serieRepository;
    }
    @Override
    public List<SerieResponseDTO> findBySeasonsIdGreaterThan(Integer seasonNumber) {
        return serieRepository.findBySeasonsIdGreaterThan(seasonNumber).stream()
                .map(serie -> modelMapper.map(serie, SerieResponseDTO.class)).collect(Collectors.toList());
    }
}
