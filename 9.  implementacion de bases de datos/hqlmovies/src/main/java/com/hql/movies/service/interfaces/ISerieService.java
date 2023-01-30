package com.hql.movies.service.interfaces;

import com.hql.movies.model.Serie;
import com.hql.movies.service.interfaces.generics.ICrudService;

import java.util.List;

public interface ISerieService extends ICrudService<Serie, Integer> {
    List<Serie> getSeriesWithMoreSeasonsThan(Integer quantitySeasons);
}
