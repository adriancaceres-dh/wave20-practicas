package com.bootcamp.movies.service.interfaces;

import com.bootcamp.movies.dto.SerieDTO;

import java.util.List;

public interface ISerieService {

    List<SerieDTO> getSeriesWhooseNumberOfSeasonsIsGreaterThan(Integer cant);
}
