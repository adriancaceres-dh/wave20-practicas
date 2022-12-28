package com.bootcamp.blog.dto.response;

import com.bootcamp.blog.dto.response.EntradaBlogRequestDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MensajeEntradaBlogResponseDto{
    private String mensaje;
    private EntradaBlogRequestDto entradaBlogRequestDto;
}
