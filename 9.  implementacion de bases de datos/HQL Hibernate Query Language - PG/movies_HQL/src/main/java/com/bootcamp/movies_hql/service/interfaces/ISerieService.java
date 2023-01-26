package com.bootcamp.movies_hql.service.interfaces;

import com.bootcamp.movies_hql.dto.response.SerieDTO;
import com.bootcamp.movies_hql.service.interfaces.generics.ICrudService;

import java.util.List;

public interface ISerieService extends ICrudService<SerieDTO, Long> {

    // Listar todas las series que tengan más de <cantidad de temporadas recibida por parámetro>
    List<SerieDTO> getSeriesWithNumberSeasonHigherThan(int cant_season);

}
