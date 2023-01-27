package com.bootcamp.MoviesHQL.service;

import com.bootcamp.MoviesHQL.dto.response.SerieResponseDTO;
import java.util.List;

public interface ISerieService {
    List<SerieResponseDTO> findBySeasonsIdGreaterThan(Integer seasonNumber);
}
