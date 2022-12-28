package com.bootcamp.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MensajeEntradaBlogResponseDto{
    private String mensaje;
    private EntradaBlogRequestDto entradaBlogRequestDto;
}
