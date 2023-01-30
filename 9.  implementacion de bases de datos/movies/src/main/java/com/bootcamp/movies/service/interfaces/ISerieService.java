package com.bootcamp.movies.service.interfaces;

import com.bootcamp.movies.dto.SeasonDto;
import com.bootcamp.movies.dto.SerieDto;

import java.util.List;

public interface ISerieService {
    List<SerieDto> findAllSeriesWhenHaveMoreSeasonsThan(Integer amountOfSeasons);
}
