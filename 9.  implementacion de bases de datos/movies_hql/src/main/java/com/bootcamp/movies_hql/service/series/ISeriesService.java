package com.bootcamp.movies_hql.service.series;

import com.bootcamp.movies_hql.dto.SeriesDTO;

import java.util.Set;

public interface ISeriesService {

    Set<SeriesDTO> getSeriesBySeasonCountGreaterThan(Integer count);
}
