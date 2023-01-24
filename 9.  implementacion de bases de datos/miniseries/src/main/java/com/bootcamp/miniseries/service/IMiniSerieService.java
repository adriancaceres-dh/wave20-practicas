package com.bootcamp.miniseries.service;

import com.bootcamp.miniseries.dto.MiniSerieDTO;
import com.bootcamp.miniseries.dto.ResultDTO;

public interface IMiniSerieService {
    ResultDTO createSerie(MiniSerieDTO miniSerieDTO);
}
