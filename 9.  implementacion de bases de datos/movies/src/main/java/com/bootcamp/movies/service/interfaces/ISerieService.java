package com.bootcamp.movies.service.interfaces;

import com.bootcamp.movies.dto.response.SimpleSerieDto;
import com.bootcamp.movies.model.Serie;

import java.util.List;

public interface ISerieService {
    List<SimpleSerieDto> findSeriesThatHaveMoreSeasonsThat(Integer numberOfSeasons);
}
