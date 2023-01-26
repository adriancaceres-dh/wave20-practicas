package com.bootcamp.movies_hql.service;

import com.bootcamp.movies_hql.dto.response.MovieDTO;
import com.bootcamp.movies_hql.dto.response.SerieDTO;
import com.bootcamp.movies_hql.entity.Movie;
import com.bootcamp.movies_hql.entity.Serie;
import com.bootcamp.movies_hql.exception.NotFoundException;
import com.bootcamp.movies_hql.repository.IGenreRepository;
import com.bootcamp.movies_hql.repository.ISerieRepository;
import com.bootcamp.movies_hql.service.interfaces.ISerieService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SerieService implements ISerieService {

    @Autowired
    ISerieRepository serieRepository;

    @Autowired
    IGenreRepository genreRepository;

    private final ModelMapper mapper = new ModelMapper();

    public SerieService() {
        mapper.getConfiguration()
                .setFieldMatchingEnabled(true);
    }

    @Override
    public SerieDTO saveEntity(SerieDTO crudDTO) {
        var entity = mapper.map(crudDTO, Serie.class);

        var entityGenre = genreRepository.findById(crudDTO.getGenre().getId()).get();

        entity.setGenre(entityGenre);

        entity = serieRepository.save(entity);

        return mapper.map(entity, SerieDTO.class);
    }

    @Override
    public SerieDTO getEntityById(Long id) {
        if (!serieRepository.existsById(id)) {
            throw new NotFoundException("Esa película no existe.");
        }
        Serie serie = serieRepository.findById(id).get();
        return mapper.map(serie, SerieDTO.class);
    }

    @Override
    public List<SerieDTO> getAllEntities() {
        return serieRepository.findAll().stream().map(m -> mapper.map(m, SerieDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public String deleteEntity(Long id) {
        if (!serieRepository.existsById(id)) {
            throw new NotFoundException("Esa película no existe.");
        }
        Serie serie = serieRepository.findById(id).get();
        String title = serie.getTitle();
        serieRepository.deleteById(id);
        return "Se ha eliminado la serie: " + title;
    }

    @Override
    public List<SerieDTO> getSeriesWithNumberSeasonHigherThan(int cant_season) {
        return serieRepository.findSerieByNumberSeason(cant_season).stream().map(m -> mapper.map(m, SerieDTO.class))
                .collect(Collectors.toList());
    }
}
