package com.jpa.la_perla.servicio;

import com.jpa.la_perla.dto.JewerlyResponseCompleteDto;
import com.jpa.la_perla.dto.JewerlyResponseDto;
import com.jpa.la_perla.dto.JewerlyRequestDto;
import com.jpa.la_perla.excepcion.NotFound;
import com.jpa.la_perla.modelo.Jewerly;

import java.util.List;

public interface IJewerlyService {

     JewerlyResponseDto create(JewerlyRequestDto joya);

     List<Jewerly>  get();

     String delete(Integer id);

     JewerlyResponseCompleteDto update(Integer id, JewerlyRequestDto jewerlyRequestDto) throws NotFound;
}
