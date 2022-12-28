package com.bootcamp.blog.service;


import com.bootcamp.blog.dto.response.EntradaBlogRequestDto;
import com.bootcamp.blog.dto.response.EntradaBlogResponseDto;
import com.bootcamp.blog.dto.response.MensajeEntradaBlogResponseDto;

import java.util.List;

public interface IBlogService {
    List<EntradaBlogResponseDto> getEntradaBlogResponseDtos(String id);
    MensajeEntradaBlogResponseDto addEntrada(EntradaBlogRequestDto entradaBlogRequestDto);
}
