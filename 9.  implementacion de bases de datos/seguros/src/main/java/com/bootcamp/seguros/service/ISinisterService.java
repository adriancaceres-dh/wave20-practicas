package com.bootcamp.seguros.service;

import com.bootcamp.seguros.dto.SinisterDTO;

public interface ISinisterService {
    SinisterDTO createSinister(SinisterDTO sinisterDTO, Long id);
}
