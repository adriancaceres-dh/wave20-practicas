package com.spring.blog.service;


import com.spring.blog.dto.EntradaBlogRequestDto;
import com.spring.blog.dto.EntradaBlogResponseDto;
import com.spring.blog.dto.MensajeEntradaBlogResponseDto;

import java.util.List;

public interface IBlogService {
    List<EntradaBlogResponseDto> getEntradaBlogResponseDtos(String id);
    MensajeEntradaBlogResponseDto addEntrada(EntradaBlogRequestDto entradaBlogRequestDto);
}
