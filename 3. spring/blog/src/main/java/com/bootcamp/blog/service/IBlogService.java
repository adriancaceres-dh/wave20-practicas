package com.bootcamp.blog.service;


import com.bootcamp.blog.dto.EntradaBlogRequestDto;
import com.bootcamp.blog.dto.EntradaBlogResponseDto;
import com.bootcamp.blog.dto.MensajeEntradaBlogResponseDto;

import java.util.List;

public interface IBlogService {
    List<EntradaBlogResponseDto> getEntradaBlogResponseDtos(String id);
    MensajeEntradaBlogResponseDto addEntrada(EntradaBlogRequestDto entradaBlogRequestDto);
}
