package com.hql.movies.service;

import com.hql.movies.dto.MessageDTO;
import com.hql.movies.model.Serie;
import com.hql.movies.repository.ISerieRepository;
import com.hql.movies.service.interfaces.ISerieService;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SerieService implements ISerieService {
    ISerieRepository serieRepository;

    public SerieService(ISerieRepository serieRepository) {
        this.serieRepository = serieRepository;
    }

    @Override
    public Serie saveEntity(Serie personDTO) {
        return null;
    }

    @Override
    public Serie getEntityById(Integer integer) {
        return null;
    }

    @Override
    public List<Serie> getAllEntities() {
        return null;
    }

    @Override
    public MessageDTO deleteEntity(Integer integer) {
        return null;
    }


    @Override
    public List<Serie> getSeriesWithMoreSeasonsThan(Integer quantitySeasons) {
        return serieRepository.findAllSeriesWithMoreSeasons(quantitySeasons);
    }
}
