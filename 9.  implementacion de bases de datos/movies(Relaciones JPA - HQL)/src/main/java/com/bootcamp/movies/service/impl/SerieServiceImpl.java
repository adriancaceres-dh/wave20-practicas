package com.bootcamp.movies.service.impl;

import com.bootcamp.movies.dto.SerieDTO;
import com.bootcamp.movies.entity.Serie;
import com.bootcamp.movies.repository.ISerieRepository;
import com.bootcamp.movies.service.interfaces.ISerieService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SerieServiceImpl implements ISerieService {

    @Autowired
    private ISerieRepository serieRepository;

    private ModelMapper mapper = new ModelMapper();

    public List<SerieDTO> getSeriesWhooseNumberOfSeasonsIsGreaterThan(Integer cant){
        List<Serie> series = serieRepository.findByNumberOfSeasonsGreaterThan(cant);
        return series.stream().map(s -> mapper.map(s, SerieDTO.class)).collect(Collectors.toList());
    }
}
