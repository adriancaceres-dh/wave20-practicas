package com.example.peliculas.service.impl;

import com.example.peliculas.dto.SerieDto;
import com.example.peliculas.entity.Serie;
import com.example.peliculas.repository.ISerieRepository;
import com.example.peliculas.service.ISerieService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SerieService implements ISerieService {
    @Autowired
    ISerieRepository serieRepository;

    ModelMapper modelMapper;

    public SerieService() {
        this.modelMapper = new ModelMapper();
    }

    @Override
    public List<SerieDto> findAllBySeasonsNumber(Integer number) {

        List<SerieDto> series = serieRepository.findAllBySeasonsNumber(number)
                .stream().map(s -> modelMapper.map(s, SerieDto.class)).collect(Collectors.toList());

        return series;
    }
}
