package com.bootcamp.MoviesHQL.service;

import com.bootcamp.MoviesHQL.dto.response.SerieResponseDTO;

import java.util.List;

public interface ISeasonService {
    List<SerieResponseDTO> findSerieBySeasonNumber(Integer seasonNumber);
}
