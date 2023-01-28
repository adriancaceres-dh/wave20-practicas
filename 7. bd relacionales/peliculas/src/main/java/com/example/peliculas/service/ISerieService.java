package com.example.peliculas.service;

import com.example.peliculas.dto.SerieDto;
import com.example.peliculas.entity.Serie;

import java.util.List;

public interface ISerieService{


    List<SerieDto> findAllBySeasonsNumber(Integer number);

}
