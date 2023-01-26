package com.bootcamp.MoviesHQL.service;

import com.bootcamp.MoviesHQL.dto.response.SerieResponseDTO;
import com.bootcamp.MoviesHQL.repository.ISeasonRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SeasonService implements ISeasonService{
    private final ISeasonRepository seasonRepository;
    ModelMapper modelMapper = new ModelMapper();

    public SeasonService(ISeasonRepository seasonRepository) {
        this.seasonRepository = seasonRepository;    }

    @Override
    public List<SerieResponseDTO> findSerieBySeasonNumber(Integer seasonNumber) {
        return seasonRepository.findSerieBySeasonNumber(seasonNumber).stream()
                .map(serie -> modelMapper.map(serie, SerieResponseDTO.class)).collect(Collectors.toList());
    }
}
