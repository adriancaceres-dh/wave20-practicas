package com.spring.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MensajeEntradaBlogResponseDto{
    private String mensaje;
    private EntradaBlogRequestDto entradaBlogRequestDto;

    public MensajeEntradaBlogResponseDto(String mensaje){
        this.mensaje = mensaje;
    }
}
